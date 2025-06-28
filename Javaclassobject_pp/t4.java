public class Item {
    private int itemCode;
    private String itemName;
    private double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: ₹" + price);
    }
}

class Main {
    public static void main(String[] args) {
        Item item = new Item(101, "Laptop", 50000);
        item.displayDetails();
        System.out.println("Total Cost for 2 units: ₹" + item.calculateTotalCost(2));
    }
}
