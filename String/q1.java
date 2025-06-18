import java.util.Scanner;

public class Q1_IllegalArgumentDemo {
    public static void generateException(String input) {
        // This will throw IllegalArgumentException at runtime
        String result = input.substring(5, 2);
        System.out.println(result);
    }

    public static void handleException(String input) {
        try {
            String result = input.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        // generateException(text); // Uncomment to see abrupt termination
        handleException(text);
    }
}
