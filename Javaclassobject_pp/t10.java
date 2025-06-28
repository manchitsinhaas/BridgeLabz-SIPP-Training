public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket Booked Successfully!");
    }

    public void displayDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }
}

class Main {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers: Endgame");
        ticket.bookTicket("B12", 350);
        ticket.displayDetails();
    }
}
