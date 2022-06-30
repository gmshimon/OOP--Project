import java.util.*;

class Receiver {
    private String name;
    private String profession;
    private int noOfFamilyMember;
    private String reason;
    private String address;
    private String deliveryType;

    public Receiver() {
    }

    public Receiver(String name, String profession, int noOfFamilyMember, String reason, String address,
            String deliveryType) {
        this.name = name;
        this.profession = profession;
        this.noOfFamilyMember = noOfFamilyMember;
        this.reason = reason;
        this.address = address;
        this.deliveryType = deliveryType;
    }

    public void input(Vector<Receiver> rec) {
        Scanner inp = new Scanner(System.in);

        System.out.println("\nEnter your details");
        System.out.print("Name: ");
        setName(inp.nextLine());
        System.out.print("Profession: ");
        setProfession(inp.nextLine());
        System.out.print("Number of family members: ");
        setFamily(inp.nextInt());
        inp.nextLine();
        System.out.print("State your reason: ");
        setReason(inp.nextLine());
        System.out.print("Address: ");
        setAddress(inp.nextLine());
        setDeliveryMethod();
        rec.add(new Receiver(name, profession, noOfFamilyMember, reason, address, deliveryType));// storing the details
                                                                                                 // in vector
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setFamily(int noOfFamilyMember) {
        this.noOfFamilyMember = noOfFamilyMember;
    }

    public int getFamily() {
        return noOfFamilyMember;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getDeliveryType() {
        return deliveryType;

    }

    public void setDeliveryMethod() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Choose Delivery type: \n\tPress 1 for Pick up\n\tPress 2 for Home Delivery\n");
        int choice = inp.nextInt();
        while (true) {
            if (choice == 1) {
                deliveryType = "Pick up";
                break;
            } else if (choice == 2) {
                deliveryType = "Home Delivery";
                break;
            } else {
                System.out.println("Invalid input. Try again.");
                choice = inp.nextInt();
            }
        }
    }

    public String getDeliveryMethod() {
        return deliveryType;
    }

    public String toString() {
        return "Name: " + name + "\nProfession: " + profession + "\nNumber of Family member: " + noOfFamilyMember
                + "\nReason: " + reason + "\nAddress: " + address + "\nDelivery Type: " + deliveryType;
    }

    public void displayInfo(Vector<Receiver> rec) {
        if (rec.size() == 0) {
            System.out.println("======= No Receiver Found =======");
        } else {
            System.out.println("\n==========Receiver details==========");
            for (int i = 0; i < rec.size(); i++) {
                System.out.println("\n||||||||||||||||||| Receiver" + (i + 1) + " |||||||||||||||||||");
                System.out.println(rec.get(i).toString());
            }
        }

    }

    public static void main(String[] args) {

    }
}
