import java.util.*;

public class donor {

    protected String name;
    protected String address;
    protected String type;// it can be people or restaurant

    public donor() {
        name = "";
        address = "";
        type = "";
    };

    public donor(String n, String a, String ty) {
        name = n;
        address = a;
        type = ty;
    }

    public boolean donorInput(ArrayList<String> donNameArr) { // read donor input
        boolean isMatch = false;
        Scanner Input = new Scanner(System.in);
        Vector don = new Vector();

        System.out.print("Enter Name: ");
        name = Input.nextLine();

        // check the input name matched with other name
        if (donNameArr.size() > 0) {
            for (int i = 0; i < donNameArr.size(); i++) {
                if (donNameArr.get(i).equals(name)) {
                    isMatch = true;
                    break;
                }
            }
        }
        if (isMatch) {
            System.out.println("");
            System.out.println("Input Name matches with other donors.Use different name");
            System.out.println("");
        } else {
            System.out.print("Enter Address: ");
            address = Input.nextLine();
            donNameArr.add(name);
        }
        return isMatch;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "|||||| Donor Details ||||||\n" + "Name: " + name + " Type: " + type + " Address: " + address;
    }

    public static void main(String[] arg) {

    }
}

// inheritance
// people class extends donor class
class people extends donor {
    private double amount;

    people() {
        amount = 0.0;
    }

    public people(String name, String address, String type, double amount) {
        super(name, address, type);
        this.amount = amount;
    }

    public people(ArrayList<String> donorNameArray, Vector<donor> don, Vector<people> pp) {
        Scanner inp = new Scanner(System.in);
        amount = 0.0;
        type = "People";// inherited from donor class

        // System.out.println("people");
        boolean isMatch = donorInput(donorNameArray); // function of superclass donor;

        if (!isMatch) {
            System.out.print("Enter Amount of money: ");
            amount = inp.nextDouble();

            // storing the information of people donor in a vector type donor
            don.add(new people(name, address, type, amount));

            // store the information of people donor in a different vector
            pp.add(new people(name, address, type, amount));
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "\n||||||Donor type:" + type + "||||||\nName: " + name + "\naddress:" + address + "\namount: " + amount;
    }
}

// restaurant class extend donor
class restaurant extends donor {
    private String foodType;

    restaurant() {
        foodType = "";
    }

    public restaurant(String name, String address, String type, String foodType) {
        super(name, address, type);
        this.foodType = foodType;
    }

    public restaurant(ArrayList donorNameArray, Vector<donor> don, Vector<restaurant> rr) {
        Scanner inp = new Scanner(System.in);
        foodType = "";

        System.out.println("Restaurant");

        type = "Restaurant"; // inherited from donor class
        boolean isMatch = donorInput(donorNameArray);

        if (!isMatch) {
            System.out.print("Food type: " + foodType);
            foodType = inp.nextLine();

            // storing the information of restaurant donor in a vector type donor
            don.add(new restaurant(name, address, type, foodType));

            // store the information of restaurant donor in a different vector
            rr.add(new restaurant(name, address, type, foodType));
        }
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public String toString() {
        return "\n\n||||||Donor type:" + type + "||||||\nName of restaurant: " + name + "\naddress:" + address
                + "\nFood type: " + foodType;
    }

}