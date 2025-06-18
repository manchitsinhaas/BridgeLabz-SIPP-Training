import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter from city: ");
        String fromCity = input.nextLine();
        System.out.print("Enter via city: ");
        String viaCity = input.nextLine();
        System.out.print("Enter to city: ");
        String toCity = input.nextLine();

        System.out.print("Enter distance from From City to Via City (in miles): ");
        double fromToVia = input.nextDouble();
        System.out.print("Enter distance from Via City to Final City (in miles): ");
        double viaToFinalCity = input.nextDouble();

        System.out.print("Enter time from From City to Via City (in minutes): ");
        int timeFromToVia = input.nextInt();
        System.out.print("Enter time from Via City to Final City (in minutes): ");
        int timeViaToFinalCity = input.nextInt();

        double totalDistanceKm = (fromToVia + viaToFinalCity) * 1.60934; // miles to km
        int totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " +
            toCity + " via " + viaCity + " is " + totalDistanceKm + " km and the Total Time taken is " + totalTime + " minutes.");
    }
}
