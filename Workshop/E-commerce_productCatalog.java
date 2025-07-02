import java.util.*;

// Product class to store product details
class Product {
    String name;
    String category;
    double price;
    int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", Category=" + category + ", Price=" + price + ", Stock=" + stock + "]";
    }
}

// ProductCatalog class to manage products
class ProductCatalog {
    List<Product> products = new ArrayList<>();
    final int MAX_STOCK = 1000; // Max stock limit

    // Add a new product
    public void addProduct(String name, String category, double price, int stock) {
        if (stock < 0 || stock > MAX_STOCK) {
            throw new IllegalArgumentException("Invalid stock quantity.");
        }
        products.add(new Product(name, category, price, stock));
    }

    // Search products by name
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }

    // Search products by category
    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.category.equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Update stock of a product
    public void updateStock(String name, int newStock) {
        boolean found = false;
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                found = true;
                if (newStock < 0 || newStock > MAX_STOCK) {
                    throw new IllegalArgumentException("Invalid stock quantity.");
                }
                p.stock = newStock;
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Product not found: " + name);
        }
    }

    // Generate report sorted by price
    public void generateReport(boolean ascending) {
        products.sort((p1, p2) -> ascending ?
                Double.compare(p1.price, p2.price) :
                Double.compare(p2.price, p1.price));

        System.out.println("Product Report:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

// Main class to test the catalog
public class ECommerceCatalogDemo {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Adding products
        catalog.addProduct("Laptop", "Electronics", 60000, 50);
        catalog.addProduct("Mobile", "Electronics", 30000, 200);
        catalog.addProduct("Shirt", "Clothing", 1500, 150);
        catalog.addProduct("Jeans", "Clothing", 2000, 100);

        // Searching
        System.out.println("Search by name 'Laptop': " + catalog.searchByName("Laptop"));
        System.out.println("Search by category 'Clothing': " + catalog.searchByCategory("Clothing"));

        // Updating stock
        try {
            catalog.updateStock("Laptop", 70);
            System.out.println("Updated Laptop stock successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Error case: updating non-existing product
        try {
            catalog.updateStock("Tablet", 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Error case: invalid stock
        try {
            catalog.updateStock("Mobile", -5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Report sorted by price ascending
        catalog.generateReport(true);

        // Report sorted by price descending
        catalog.generateReport(false);
    }
}
