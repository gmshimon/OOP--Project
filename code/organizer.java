import java.util.*;

public class organizer {
    private volunteer Volunteer;
    protected Receiver receiver;

    public organizer(volunteer Volunteer, Receiver receiver) {
        this.Volunteer = Volunteer;
        this.receiver = receiver;
    }

    // method Volunteer class to take input of volunteer
    public void takeInput(Vector<volunteer> vol, ArrayList nameArray) {
        Volunteer.takeInput(vol, nameArray);
    }

    // method to call displayVolunteer of Volunteer class
    public void displayVolunteerMethod(Vector<volunteer> vol) {
        Volunteer.displayVolunteer(vol);
    }

    // method to call deliverItem of Volunteer class
    public void deliverItemMethod(Vector<volunteer> vol, Vector<Receiver> acc, people people, restaurant rest,
            String type,
            int value) {
        Volunteer.deliverItem(vol, acc, people, rest, type, value);
    }

    // method to call input of receiver class
    public void inputReceiver(Vector<Receiver> rec) {
        receiver.input(rec);
    }

    public static void main(String[] args) {
        volunteer V = new volunteer(); // volunteer class object

        Receiver rcvr = new Receiver(); // receiver class object

        organizer Organizer = new organizer(V, rcvr); // organizer object

        donor Donor = new donor();

        people people = new people(); // people class object
        restaurant rest = new restaurant(); // restaurant class object

        Vector<Receiver> rec = new Vector<Receiver>(); // creating a vector to store the receiver details

        Vector<Receiver> acc = new Vector<Receiver>(); // creating vector of accepted receiver

        Vector<volunteer> vol = new Vector<volunteer>();// creating a vector to store the volunteer details

        Vector<donor> don = new Vector<donor>();// creating a vector to store the donor details

        Vector<people> pp = new Vector<people>();// creating a vector to store the people donor

        Vector<restaurant> rr = new Vector<restaurant>();// creating a vector to store the restaurant donor

        ArrayList<String> donorNameArray = new ArrayList<String>();
        ArrayList nameArray = new ArrayList();

        Scanner inp = new Scanner(System.in);

        int choice;
        int choice2;
        String name;
        boolean isMatch = false;
        String type = "";

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t Welcome to our organization");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");

        do {
            System.out.println("Enter your choice\npress 0 to exit the program");
            System.out.println("---------------------------------------");
            System.out.println("1. Make donation");
            System.out.println("2. Print all donors");
            System.out.println("3. Register as a Volunteer");
            System.out.println("4. Print all Volunteers");
            System.out.println("5. Deliver Items");
            System.out.println("6. Want to take donation??Register now");
            System.out.println("");
            System.out.print("Choice: ");
            choice = inp.nextInt();
            switch (choice) {
                case 1: {
                    int ch = 0;
                    System.out.println("");
                    System.out.println("1. People");
                    System.out.println("2. Restaurant");
                    System.out.print("Enter your choice: ");
                    ch = inp.nextInt();
                    if (ch == 1) {
                        people p = new people(donorNameArray, don, pp);
                    } else if (ch == 2) {
                        restaurant r = new restaurant(donorNameArray, don, rr);
                    }
                    break;
                }
                case 2: {
                    if (don.size() == 0) {
                        System.out.println("NO Donor found\n");
                    } else {
                        System.out.println("All Donor Information is as follows:");

                        // printing the information of donor type==people
                        for (int i = 0; i < pp.size(); i++) {
                            System.out.println(pp.get(i).toString());
                        }
                        // printing the information of donor type==restaurant
                        for (int f = 0; f < rr.size(); f++) {
                            System.out.println(rr.get(f).toString());
                        }

                    }
                    break;
                }

                case 3: {
                    Organizer.takeInput(vol, nameArray);
                    break;
                }
                case 4: {
                    Organizer.displayVolunteerMethod(vol);
                    break;
                }
                case 5: {

                    System.out.println("");
                    System.out.println("<<<<<<<<<Select the option>>>>>>>>>>>>");
                    System.out.println("1. Review the Receiver");
                    System.out.println("2. Donate\n");
                    System.out.print("Your Choice: ");
                    choice2 = inp.nextInt();
                    switch (choice2) {
                        case 1: {
                            if (rec.size() > 0) {
                                Scanner input = new Scanner(System.in);
                                String choice3;
                                System.out.println("");
                                System.out.println("###########Receiver details###########");
                                for (int i = 0; i < rec.size(); i++) {
                                    // print details of receiver one by one
                                    System.out.println("Name: " + rec.get(i).getName());
                                    System.out.println("Prof: " + rec.get(i).getProfession());
                                    System.out.println("Reason: " + rec.get(i).getReason());
                                    System.out.println("Number of Family: " + rec.get(i).getFamily());

                                    System.out.println("");
                                    System.out.println("Type yes to approve/No to reject: ");
                                    choice3 = input.nextLine();

                                    if (choice3.equals("yes") || choice3.equals("Yes")) {
                                        // those who are accepted are added into new vector called acc type Receiver
                                        acc.add(rec.get(i));
                                    } else if (choice3.equals("no") || choice3.equals("No")) {
                                        System.out.println("The receiver has been rejected\n");
                                    }
                                    rec.remove(i); // after accepting and rejection remove the receiver from vector
                                }
                            } else {
                                System.out.println("There is no receiver\n");
                            }
                            break;
                        }
                        case 2: {
                            try {
                                if (acc.size() > 0) {
                                    if (don.size() > 0) {
                                        int count = 1;
                                        System.out.println(
                                                "++++++++++++++++++++++List of Donation++++++++++++++++++++++");

                                        // printing the details of the donations

                                        System.out.printf("%-5s%-20s%-15s%-19s%-15s\n", "NO.", "Name", "Address",
                                                "Type",
                                                "Donation");

                                        for (int i = 0; i < pp.size(); i++) {
                                            System.out.printf("%-5d%-20s%-15s%-19s%-17s\n", count,
                                                    pp.get(i).getName(),
                                                    pp.get(i).getAddress(), pp.get(i).getType(),
                                                    pp.get(i).getAmount() + "(money)");
                                            count++;
                                        }

                                        for (int j = 0; j < rr.size(); j++) {
                                            System.out.printf("%-5d%-20s%-15s%-19s%-17s\n", count, rr.get(j).getName(),
                                                    rr.get(j).getAddress(), rr.get(j).getType(),
                                                    rr.get(j).getFoodType() +
                                                            "(food)");

                                            count++;
                                        }
                                    } else {
                                        System.out.println("=====no donor=====\n");
                                    }
                                    if (acc.size() > 0) {
                                        // print the details of the receiver
                                        System.out.println(
                                                "++++++++++++++++++++++List of Accepted Receiver++++++++++++++++++++++");
                                        System.out.printf("%-5s%-20s%-15s%-19s%-15s%-10s\n", "NO.", "Name", "Address",
                                                "No. of Family",
                                                "Reason", "Delivery Method");
                                        for (int i = 0; i < acc.size(); i++) {
                                            System.out.printf("%-5d%-20s%-20s%-14d%-17s%-10s\n", (i + 1),
                                                    acc.get(i).getName(),
                                                    acc.get(i).getAddress(), acc.get(i).getFamily(),
                                                    acc.get(i).getReason(),
                                                    acc.get(i).getDeliveryType());
                                        }

                                        System.out.println("");

                                        if (don.size() == 0) {
                                            System.out.println(
                                                    "Sorry we do not have any donation right now.. Later we will try to deliver the donation\n");
                                        } else {
                                            Scanner input = new Scanner(System.in);
                                            System.out.println("");
                                            System.out.print("Type donors name to donate the receiver: ");
                                            name = input.nextLine();

                                            // check the input name with donor list name
                                            for (int i = 0; i < don.size(); i++) {
                                                if (don.get(i).getName().equals(name)) {
                                                    type = don.get(i).getType();
                                                    isMatch = true;
                                                    don.remove(i);// remove the donor from donor vector
                                                    donorNameArray.remove(i); // remove donor name from donor name arrat
                                                    break;
                                                }
                                            }

                                            if (isMatch) {
                                                Random random = new Random();
                                                // generate random number to pick random index number of volunteer
                                                int value = 0;
                                                if (vol.size() > 0) {
                                                    for (int i = 0; i < vol.size(); i++) {
                                                        value = random.nextInt(0 + vol.size()) + 0;
                                                    }
                                                }
                                                for (int i = 0; i < pp.size(); i++) {
                                                    if (pp.get(i).getName().equals(name)) {
                                                        people = pp.get(i); // copy the data of people vector of index i
                                                                            // to
                                                                            // object people
                                                        pp.remove(i);
                                                        Organizer.deliverItemMethod(vol, acc, people, rest, type,
                                                                value);
                                                        break;
                                                    }
                                                }
                                                for (int i = 0; i < rr.size(); i++) {
                                                    if (rr.get(i).getName().equals(name)) {
                                                        rest = rr.get(i);
                                                        rr.remove(i);
                                                        Organizer.deliverItemMethod(vol, acc, people, rest, type,
                                                                value);
                                                        // // volunteer
                                                        // vector,
                                                        // receiver
                                                        // vector,
                                                        // people
                                                        // donor
                                                        // object,
                                                        // restaurant
                                                        // donor
                                                        // object,
                                                        // type
                                                        // of
                                                        // donor==
                                                        // passed
                                                        break;
                                                    }
                                                }
                                            } else {
                                                System.out.println("Donor name does not match");
                                            }
                                        }
                                    } else {
                                        System.out.println("There is no Receiver to take donation\n");
                                    }
                                } else {
                                    System.out.println(
                                            "\nThere is no accepted receiver... Please accept receiver at first\n");
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Something went wrong... try again Later");
                            }

                        }
                        default: {
                            System.out.println("Wrong choice\n");
                            break;
                        }
                    }

                    break;
                }
                case 6: {
                    System.out.println(" Provide details");
                    Organizer.inputReceiver(rec);
                    break;
                }
            }
        } while (choice != 0);
    }
}
