import java.util.*;

public class organizer {
    public static void main(String[] args) {

        volunteer Volunteer = new volunteer();
        Receiver rcvr = new Receiver();
        donor Donor = new donor();
        // people pp = new people();
        // restaurant rr = new restaurant();

        Vector<Receiver> rec = new Vector<Receiver>(); // creating a vector to store the receiver details

        Vector<volunteer> vol = new Vector<volunteer>();// creating a vector to store the volunteer details

        Vector<donor> don = new Vector<donor>();// creating a vector to store the donor details

        Vector<people> pp = new Vector<people>();// creating a vector to store the people donor

        Vector<restaurant> rr = new Vector<restaurant>();// creating a vector to store the restaurant donor

        ArrayList<String> donorNameArray = new ArrayList<String>();
        ArrayList nameArray = new ArrayList();

        Scanner inp = new Scanner(System.in);

        int choice;
        String name;

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
                    Volunteer.takeInput(vol, nameArray);
                    break;
                }
                case 4: {
                    Volunteer.displayVolunteer(vol);
                    break;
                }
                case 5: {
                    if (don.size() > 0) {
                        int count = 1;
                        System.out.println("++++++++++++++++++++++List of Donation++++++++++++++++++++++");

                        // printing the details of the donations

                        System.out.printf("%-5s%-20s%-15s%-19s%-15s\n", "NO.", "Name", "Address", "Type",
                                "Donation");
                        for (int i = 0; i < don.size(); i++) {
                            if (don.get(i).getType() == "People") {
                                System.out.printf("%-5d%-20s%-15s%-19s%-17s\n", count,
                                        pp.lastElement().getName(),
                                        pp.lastElement().getAddress(), pp.lastElement().getType(),
                                        pp.lastElement().getAmount() + "(money)");
                            } else {
                                System.out.printf("%-5d%-20s%-15s%-19s%-17s\n", count, rr.lastElement().getName(),
                                        rr.lastElement().getAddress(), rr.lastElement().getType(),
                                        rr.lastElement().getFoodType() +
                                                "(food)");
                            }
                            count++;
                        }
                    } else {
                        System.out.println("no donor");
                    }
                    System.out.println("");
                    if (rec.size() > 0) {

                        System.out.println("++++++++++++++++++++++List of Receiver++++++++++++++++++++++");

                        System.out.printf("%-5s%-20s%-15s%-19s%-15s%-10s\n", "NO.", "Name", "Address", "No. of Family",
                                "Reason", "Delivery Method");
                        for (int i = 0; i < rec.size(); i++) {
                            System.out.printf("%-5d%-20s%-20s%-14d%-17s%-10s\n", (i + 1), rec.get(i).getName(),
                                    rec.get(i).getAddress(), rec.get(i).getFamily(), rec.get(i).getReason(),
                                    rec.get(i).getDeliveryType());
                        }

                        System.out.println("");
                        Volunteer.deliverItem(vol, don, rec, pp, rr);// vector of volunteer,
                        // donor,receiver,
                        // people,donor and restaurant donor have been
                        // passed
                    } else {
                        System.out.println("There is no Receiver to take donation\n");
                    }
                    break;
                }
                case 6: {
                    System.out.println(" Provide details");
                    rcvr.input(rec);
                    // rcvr.displayInfo(rec);
                    break;
                }
            }
        } while (choice != 0);
    }
}
