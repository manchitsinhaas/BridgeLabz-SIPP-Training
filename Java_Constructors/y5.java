public class Book {
    private String title;
    private String author;
    private double price;
    private boolean available = true;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean borrowBook() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }
}
