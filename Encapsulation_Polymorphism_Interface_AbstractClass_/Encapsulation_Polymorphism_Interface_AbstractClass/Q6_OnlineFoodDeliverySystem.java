import java.util.Scanner;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + calculateTotalPrice());
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20; // Extra charge for non-veg
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

public class Q6_OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println(d.getDiscountDetails());
            System.out.println("Discount: " + d.applyDiscount());
            System.out.println("Payable Amount: " + (item.calculateTotalPrice() - d.applyDiscount()));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodItem[] items = new FoodItem[2];

        System.out.print("Enter Veg Item Name: ");
        String vName = sc.nextLine();
        System.out.print("Price: ");
        double vPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int vQty = sc.nextInt();
        sc.nextLine();
        items[0] = new VegItem(vName, vPrice, vQty);

        System.out.print("\nEnter Non-Veg Item Name: ");
        String nvName = sc.nextLine();
        System.out.print("Price: ");
        double nvPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int nvQty = sc.nextInt();
        items[1] = new NonVegItem(nvName, nvPrice, nvQty);

        for (FoodItem item : items) {
            processOrder(item);
        }
    }
}
