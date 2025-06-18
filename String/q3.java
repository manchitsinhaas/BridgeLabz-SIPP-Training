import java.util.Scanner;

public class Q3_StringIndexDemo {
    public static void generateException(String input) {
        System.out.println(input.charAt(input.length())); // Invalid
    }

    public static void handleException(String input) {
        try {
            System.out.println(input.charAt(input.length())); // Invalid
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        // generateException(text); // Uncomment to crash
        handleException(text);
    }
}
