import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Step 2: Define array for multiplication results (1 to 10 => 10 elements)
        int[] multiplicationResult = new int[10];

        // Step 3: Store results in array using loop
        for (int i = 0; i < 10; i++) {
            multiplicationResult[i] = number * (i + 1);
        }

        // Step 4: Display in format number * i = result
        for (int i = 0; i < 10; i++) {
            int multiplier = i + 1;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        sc.close();
    }
}
