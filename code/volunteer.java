import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class volunteer { // volunteer class

  private String name;
  private int age;
  private String profession;

  public volunteer() {
  };

  public volunteer(String n, int a, String p) {
    name = n;
    age = a;
    profession = p;
  }

  public void takeInput(Vector<volunteer> vol, ArrayList nameArr) { // read volunteer input

    Scanner Input = new Scanner(System.in);

    System.out.print("Enter Name:");
    name = Input.nextLine();
    System.out.print("Enter Age:");
    age = Input.nextInt();
    Input.nextLine();
    System.out.print("Enter Prof:");
    profession = Input.nextLine();

    vol.add(new volunteer(name, age, profession));
    nameArr.add(name);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getProfession() {
    return profession;
  }

  public String toString() {
    return "Name: " + name + "\nAge: " + age + "\nProfession: " + profession;
  }

  public void displayVolunteer(Vector<volunteer> vol) {
    if (vol.size() == 0) {
      System.out.println("======= No Volunteer Found =======");
    } else {
      System.out.println("\n==========Volunteer details==========");
      for (int i = 0; i < vol.size(); i++) {
        System.out.println("\n||||||||||||||||||| Volunteer" + (i + 1) + " |||||||||||||||||||");
        System.out.println(vol.get(i).toString());
      }
    }
  }

  // assign a volunteer to deliver the item to the receiver
  public void deliverItem(Vector<volunteer> vol, Vector<donor> don, Vector<Receiver> rec, Vector<people> pp,
      Vector<restaurant> rr) {

    if (don.size() == 0) {
      System.out.println("Sorry we do not have any donation right now.. Later we will try to deliver the donation\n");
    } else {
      Scanner Input = new Scanner(System.in);
      String name;

      System.out.println("");
      System.out.print("Type donors name to donate the receiver: ");

      name = Input.next();

      for (int d = 0, r = 0; d < don.size() && r < rec.size(); d++, r++) {

        // checks the deliver method the receiver wants
        if (rec.get(r).getDeliveryMethod() == "Home Delivery") {
          if (vol.size() > 0) {
            for (int j = 0; j < vol.size(); j++) {
              // check the input donor name matches or not
              if (don.get(d).getName().equals(name)) {

                // check the donor type
                if (don.get(d).getType() == "People") {
                  for (int i = 0; i < pp.size(); i++) {
                    System.out.println(rec.get(r).getName() + " Has got donation from " + don.get(d).getName()
                        + ". Amount of money: " + pp.get(i).getAmount());
                    System.out.println("Volunteer,name: " + vol.get(j).getName() + " will deliver to your address");
                    pp.remove(i);
                    don.remove(d);
                  }
                } // end of if

                // restaurant type donor
                else {
                  for (int i = 0; i < rr.size(); i++) {
                    System.out.println(rec.get(r).getName() + " Has got donation from " + don.get(d).getName()
                        + ". Type of food: " + rr.get(i).getFoodType());
                    System.out.println("Volunteer,name: " + vol.get(j).getName() + " will deliver to your address");
                    rr.remove(i);
                    don.remove(d);
                  }
                }
              } // end of third if
              else {
                System.out.println("Donor name does not match");
              }
            }

          } // end of second if
          else {
            System.out.println("Sorry currently no volunteer available");
          }
        } // end of first if
        else {
          if (don.get(d).getName().equals(name)) {
            // System.out.println(don.get(d).getType());
          } else {
            System.out.println("Donor name does not match");
          }
        }

      }
    }
  }

  public static void main(String[] arg) {

  }
}
