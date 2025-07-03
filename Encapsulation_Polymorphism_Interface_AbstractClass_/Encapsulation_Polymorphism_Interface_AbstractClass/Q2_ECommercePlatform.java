import java.util.Scanner;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class Q2_ECommercePlatform {
    public static void printFinalPrice(Product p) {
        double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
        double discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;
        System.out.println("\nProduct: " + p.getName());
        System.out.println("Price: " + p.getPrice());
        if (p instanceof Taxable) System.out.println(((Taxable) p).getTaxDetails());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[3];

        System.out.print("Enter Electronics Name: ");
        String eName = sc.nextLine();
        System.out.print("Enter Price: ");
        double ePrice = sc.nextDouble();
        sc.nextLine();
        products[0] = new Electronics(1, eName, ePrice);

        System.out.print("Enter Clothing Name: ");
        String cName = sc.nextLine();
        System.out.print("Enter Price: ");
        double cPrice = sc.nextDouble();
        sc.nextLine();
        products[1] = new Clothing(2, cName, cPrice);

        System.out.print("Enter Grocery Name: ");
        String gName = sc.nextLine();
        System.out.print("Enter Price: ");
        double gPrice = sc.nextDouble();
        products[2] = new Groceries(3, gName, gPrice);

        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
