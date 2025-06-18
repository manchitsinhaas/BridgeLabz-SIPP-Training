import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 of triangle in meters: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2 of triangle in meters: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3 of triangle in meters: ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;
        double rounds = 5000 / perimeter;  // 5km = 5000 meters
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}
