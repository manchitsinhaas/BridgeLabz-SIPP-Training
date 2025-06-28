public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per Unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + getTotalCost());
    }
}

class Main {
    public static void main(String[] args) {
        CartItem item = new CartItem("Headphones", 1500, 2);
        item.displayDetails();
    }
}
