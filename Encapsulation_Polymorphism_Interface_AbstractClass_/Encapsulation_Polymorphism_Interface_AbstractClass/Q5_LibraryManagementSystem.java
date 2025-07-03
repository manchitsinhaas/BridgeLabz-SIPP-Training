import java.util.Scanner;

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration (days): " + getLoanDuration());
    }
}

interface Reservable {
    void reserveItem(String userName);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("Book reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("Magazine reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("DVD reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

public class Q5_LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryItem[] items = new LibraryItem[3];

        System.out.print("Enter Book ID: ");
        int bId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String bTitle = sc.nextLine();
        System.out.print("Author: ");
        String bAuthor = sc.nextLine();
        items[0] = new Book(bId, bTitle, bAuthor);

        System.out.print("\nEnter Magazine ID: ");
        int mId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String mTitle = sc.nextLine();
        System.out.print("Author: ");
        String mAuthor = sc.nextLine();
        items[1] = new Magazine(mId, mTitle, mAuthor);

        System.out.print("\nEnter DVD ID: ");
        int dId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String dTitle = sc.nextLine();
        System.out.print("Author: ");
        String dAuthor = sc.nextLine();
        items[2] = new DVD(dId, dTitle, dAuthor);

        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("User123");
                System.out.println("Available After Reservation: " + r.checkAvailability());
            }
            System.out.println();
        }
    }
}
