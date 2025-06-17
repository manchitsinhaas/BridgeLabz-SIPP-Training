import java.util.Scanner;

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get user input and check for natural number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a positive natural number greater than 0.");
            return; // Exit the program
        }

        // Step 2: Create arrays for odd and even numbers
        int size = number / 2 + 1; // Maximum possible size for each
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        // Step 3: Index trackers
        int evenIndex = 0;
        int oddIndex = 0;

        // Step 4: Loop from 1 to number and classify as even or odd
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Step 5: Print odd numbers array
        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println(); // line break

        // Print even numbers array
        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        sc.close();
    }
}
