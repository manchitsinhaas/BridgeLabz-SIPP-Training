import java.util.Scanner;

public class Q13_BasicCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose operation:");
        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
        int choice = sc.nextInt();

        System.out.print("Enter two numbers: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Result: " + add(x, y));
                break;
            case 2:
                System.out.println("Result: " + subtract(x, y));
                break;
            case 3:
                System.out.println("Result: " + multiply(x, y));
                break;
            case 4:
                System.out.println("Result: " + divide(x, y));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
