import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create an array of 5 integers and take input
        int[] numbers = new int[5];
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nClassification of numbers:");

        // Step 2: Loop through the array to check positive/negative/zero, and even/odd if positive
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("numbers[" + i + "] = " + num + " → ");

            if (num > 0) {
                System.out.print("Positive and ");
                if (num % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        // Step 3: Compare the first and last elements of the array
        System.out.println("\nComparison of first and last element:");
        if (numbers[0] == numbers[4]) {
            System.out.println("First and last elements are equal.");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element is greater than the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        sc.close();
    }
}
