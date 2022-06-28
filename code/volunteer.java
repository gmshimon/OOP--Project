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
      System.out.println("Sorry we dont have any donation right now.. Later we will try to deliver the donation\n");
    } else {
      for (int j = 0, f = 0; j < rec.size() && f < don.size(); j++, f++) {
        // if (don.size() > 0) {
        if (don.get(j).getType() == "People") {
          System.out.println(rec.get(j).getName() + " Has got donation from " + don.get(f).getName()
              + ". Amount of money: " + pp.get(f).getAmount());
          pp.remove(f); // remove the details of people donor from the vector
        } else {
          System.out.println(rec.get(j).getName() + " Has got donation from " + don.get(j).getName() + " restaurant"
              + ". Food Type: " + rr.get(f).getFoodType());
          rr.remove(f);// remove the details of restaurant donor from the vector
        }
        don.remove(f); // remove donor
        rec.remove(j); // remove receiver
        // } else {
        // System.out.println("Donation not available");
        // break;
        // }
      }
    }
  }

  public static void main(String[] arg) {

  }
}
