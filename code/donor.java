import java.util.*;

public class donor { // dobor nested class

    protected String name;
    protected String address;
    protected String deliveryType;
    protected String type;// it can be people or restaurant

    public donor() {
        name = "";
        address = "";
        deliveryType = "";
    };

    public donor(String n, String a, String dt, String ty) {
        name = n;
        address = a;
        deliveryType = dt;
        type = ty;
    }

    public void donorInput(ArrayList donNameArr) { // read donor input

        Scanner Input = new Scanner(System.in);
        Vector don = new Vector();

        System.out.print("Enter Name: ");
        name = Input.nextLine();
        System.out.print("Enter Address: ");
        address = Input.nextLine();
        System.out.print("Enter Delivery Type: ");
        deliveryType = Input.nextLine();

        donNameArr.add(name);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static void main(String[] arg) {

    }
}

// inheritance
// people class extends donor class
class people extends donor {
    private double amount;

    people() {
    }

    public people(String name, String address, String deliveryType, String type, double amount) {
        super(name, address, deliveryType, type);
        this.amount = amount;
    }

    public people(ArrayList donorNameArray, Vector<donor> don, Vector<people> pp) {
        Scanner inp = new Scanner(System.in);
        amount = 0.0;
        type = "People";// inherited from donor class
        System.out.println("people");
        donorInput(donorNameArray); // function of superclass donor;
        System.out.print("Enter Amount of money: ");
        amount = inp.nextDouble();
        // storing the information of people donor in a vector type donor
        don.add(new people(name, address, deliveryType, type, amount));
        // store the information of people donor in a different vector
        pp.add(new people(name, address, deliveryType, type, amount));
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "\n||||||Donor type:" + type + "||||||\nName: " + name + "\naddress:" + address + "\nDelivery Type: "
                + deliveryType + "\namount: " + amount;
    }
}

// restaurant class extend donor
class restaurant extends donor {
    private String foodType;

    restaurant() {
    }

    public restaurant(String name, String address, String deliveryType, String type, String foodType) {
        super(name, address, deliveryType, type);
        this.foodType = foodType;
    }

    public restaurant(ArrayList donorNameArray, Vector<donor> don, Vector<restaurant> rr) {
        Scanner inp = new Scanner(System.in);
        foodType = "";
        System.out.println("Restaurant");
        type = "Restaurant"; // inherited from donor class
        donorInput(donorNameArray);
        System.out.print("Food type: " + foodType);
        foodType = inp.nextLine();
        // storing the information of restaurant donor in a vector type donor
        don.add(new restaurant(name, address, deliveryType, type, foodType));
        // store the information of restaurant donor in a different vector
        rr.add(new restaurant(name, address, deliveryType, type, foodType));
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public String toString() {
        return "\n\n||||||Donor type:" + type + "||||||\nName of restaurant: " + name + "\naddress:" + address
                + "\nDelivery Type: " + deliveryType
                + "\nFood type: " + foodType;
    }

}