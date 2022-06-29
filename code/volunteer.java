import java.text.NumberFormat.Style;
import java.util.*;

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
      System.out.printf("%-5s%-20s%-15s%-19s\n", "NO.", "Name", "Profession", "Ages");
      for (int i = 0; i < vol.size(); i++) {
        System.out.printf("%-5d%-20s%-15s%-19d\n", (i + 1),
            vol.get(i).getName(),
            vol.get(i).getProfession(), vol.get(i).getAge());
      }
      System.out.println("");
    }
  }

  // assign a volunteer to deliver the item to the receiver
  public void deliverItem(Vector<volunteer> vol, Vector<Receiver> rec, people p, restaurant rest, String type,
      int value) {

    for (int i = 0; i < rec.size(); i++) {
      // checking the delivery method
      if (rec.get(i).getDeliveryType() == "Home Delivery") {
        if (type == "People") {

          // print donation and receiver details after donation
          System.out.println(
              rec.get(i).getName() + " has got donation from " + p.getName() + ". Amount of money " + p.getAmount());
          if (vol.size() > 0) {

            // print donation and receiver details after donation
            System.out.println(vol.get(value).getName() + " will deliver the donation to your address");
          } else {
            System.out.println("Currently we dont have any volunteer.Please collect your donation.");
          }
        } else {
          System.out.println(
              // print donation and receiver details after donation
              rec.get(i).getName() + " has got donation from " + rest.getName() + ". Type of food "
                  + rest.getFoodType());
          if (vol.size() > 0) {

            // print donation and receiver details after donation
            System.out.println(vol.get(value).getName() + " will deliver the donation to your address");
          } else {
            System.out.println("Currently we dont have any volunteer.Please collect your donation.");
          }
        }
      } // end of if
      else {
        // check type of donor
        if (type == "People") {

          // print donation and receiver details after donation
          System.out.println(
              rec.get(i).getName() + " has got donation from " + p.getName() + ". Amount of money " + p.getAmount()
                  + "\n");
        } else {

          // print donation and receiver details after donation
          System.out.println(
              rec.get(i).getName() + " has got donation from " + rest.getName() + ". Type of food "
                  + rest.getFoodType() + "\n");
        }
      }
      rec.remove(i);
    }
  }

  public static void main(String[] arg) {

  }
}
