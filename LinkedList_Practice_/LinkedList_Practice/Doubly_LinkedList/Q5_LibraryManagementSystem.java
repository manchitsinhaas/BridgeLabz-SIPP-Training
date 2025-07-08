import java.util.Scanner;

class Book {
    String title, author, genre;
    int bookId;
    boolean available;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }
}

public class Q5_LibraryManagementSystem {
    Book head = null, tail = null;

    public void addAtBeginning(Book b) {
        if (head == null) head = tail = b;
        else {
            b.next = head;
            head.prev = b;
            head = b;
        }
    }

    public void addAtEnd(Book b) {
        if (tail == null) head = tail = b;
        else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    public void addAtPosition(Book b, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(b);
            return;
        }
        Book temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        if (temp.next == null) addAtEnd(b);
        else {
            b.next = temp.next;
            b.prev = temp;
            temp.next.prev = b;
            temp.next = b;
        }
    }

    public void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = tail.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitleOrAuthor(String query) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Available: " + temp.available);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {
        Q5_LibraryManagementSystem lib = new Q5_LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add Begin\n2.Add End\n3.Add Pos\n4.Delete by ID\n5.Search by Title/Author\n6.Update Availability\n7.Display Forward\n8.Display Reverse\n9.Count Books\n0.Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    System.out.print("Genre: "); String genre = sc.nextLine();
                    System.out.print("Available (true/false): "); boolean available = sc.nextBoolean();
                    Book book = new Book(title, author, genre, id, available);
                    if (choice == 1) lib.addAtBeginning(book);
                    else if (choice == 2) lib.addAtEnd(book);
                    else {
                        System.out.print("Position: "); int pos = sc.nextInt();
                        lib.addAtPosition(book, pos);
                    }
                    break;

                case 4:
                    System.out.print("Book ID to delete: ");
                    lib.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Title or Author: ");
                    String q = sc.nextLine();
                    lib.searchByTitleOrAuthor(q);
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Availability (true/false): ");
                    boolean stat = sc.nextBoolean();
                    lib.updateAvailability(uid, stat);
                    break;

                case 7: lib.displayForward(); break;
                case 8: lib.displayReverse(); break;
                case 9: lib.countBooks(); break;
            }

        } while (choice != 0);
    }
}
