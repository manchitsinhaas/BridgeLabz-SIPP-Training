import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode prev, next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class Q2_MovieManagementSystem {
    MovieNode head = null, tail = null;

    public void addAtBeginning(MovieNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addAtEnd(MovieNode node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtPosition(MovieNode node, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(node);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(node);
        } else {
            node.next = temp.next;
            node.prev = temp;
            temp.next.prev = node;
            temp.next = node;
        }
    }

    public void removeByTitle(String title) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                if (curr == head) head = head.next;
                if (curr == tail) tail = tail.prev;
                if (curr.prev != null) curr.prev.next = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                return;
            }
            curr = curr.next;
        }
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + "), Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println(temp.title + " (" + temp.year + "), Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        Q2_MovieManagementSystem list = new Q2_MovieManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Beginning\n2. Add End\n3. Add Position\n4. Remove by Title\n5. Search by Director\n6. Search by Rating\n7. Update Rating\n8. Display Forward\n9. Display Reverse\n0. Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Director: "); String director = sc.nextLine();
                    System.out.print("Year: "); int year = sc.nextInt();
                    System.out.print("Rating: "); double rating = sc.nextDouble();
                    MovieNode m = new MovieNode(title, director, year, rating);
                    if (choice == 1) list.addAtBeginning(m);
                    else if (choice == 2) list.addAtEnd(m);
                    else {
                        System.out.print("Position: "); int pos = sc.nextInt();
                        list.addAtPosition(m, pos);
                    }
                    break;

                case 4:
                    System.out.print("Movie Title: "); String del = sc.nextLine();
                    list.removeByTitle(del);
                    break;

                case 5:
                    System.out.print("Director: "); String d = sc.nextLine();
                    list.searchByDirector(d);
                    break;

                case 6:
                    System.out.print("Min Rating: "); double r = sc.nextDouble();
                    list.searchByRating(r);
                    break;

                case 7:
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("New Rating: "); double newR = sc.nextDouble();
                    list.updateRating(t, newR);
                    break;

                case 8: list.displayForward(); break;
                case 9: list.displayReverse(); break;
            }

        } while (choice != 0);
    }
}
