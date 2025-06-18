import java.util.Scanner;

public class Q6_NumberFormatDemo {
    public static void generateException(String input) {
        int number = Integer.parseInt(input); // If input is not number => Exception
        System.out.println("Parsed number: " + number);
    }

    public static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (expecting a number): ");
        String input = sc.nextLine();
        // generateException(input); // Uncomment to crash
        handleException(input);
    }
}
