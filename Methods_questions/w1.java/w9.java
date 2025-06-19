import java.util.Scanner;

public class TriangularParkRun {
    public static int calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; 
        return (int) Math.ceil(distance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of triangle (in meters): ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.println("Rounds needed to complete 5km: " + calculateRounds(a, b, c));
    }
}
