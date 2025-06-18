import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = input.nextInt();

        // Swapping
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
