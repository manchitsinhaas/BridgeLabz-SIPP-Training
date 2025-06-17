import java.util.Scanner;

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Initialize array and supporting variables
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Step 2: Start input loop
        System.out.println("Enter up to 10 positive numbers (0 or negative to stop):");

        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double input = sc.nextDouble();

            // Step 3: Check for stop condition
            if (input <= 0) {
                break;
            }

            // Step 4: Stop if array is full
            if (index == 10) {
                System.out.println("Array limit reached (10 numbers).");
                break;
            }

            // Step 5: Store the number and increment index
            numbers[index] = input;
            index++;
        }

        // Step 6: Loop to calculate total
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Step 7: Display entered numbers and total
        System.out.print("\nEntered Numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nTotal Sum: " + total);

        sc.close();
    }
}
