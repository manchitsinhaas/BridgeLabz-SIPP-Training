import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class Q9_OnlineTicketReservationSystem {
    Ticket head = null;

    public void addTicket(Ticket t) {
        if (head == null) {
            head = t;
            t.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = t;
            t.next = head;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) return;

        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }

        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets reserved.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String query) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        Q9_OnlineTicketReservationSystem system = new Q9_OnlineTicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Ticket\n2. Remove Ticket\n3. Display Tickets\n4. Search Ticket\n5. Count Tickets\n0. Exit");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Customer Name: "); String cust = sc.nextLine();
                    System.out.print("Movie Name: "); String movie = sc.nextLine();
                    System.out.print("Seat Number: "); String seat = sc.nextLine();
                    System.out.print("Booking Time: "); String time = sc.nextLine();
                    Ticket t = new Ticket(id, cust, movie, seat, time);
                    system.addTicket(t);
                    break;

                case 2:
                    System.out.print("Ticket ID to remove: ");
                    system.removeTicket(sc.nextInt());
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name: ");
                    system.searchTicket(sc.nextLine());
                    break;

                case 5:
                    system.countTickets();
                    break;
            }

        } while (choice != 0);
    }
}
