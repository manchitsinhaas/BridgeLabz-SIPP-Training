import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Step 2: Define array for multiplication results (for 6 to 9 => 4 elements)
        int[] multiplicationResult = new int[4];

        // Step 3: Store multiplication results in the array
        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = number * (6 + i);
        }

        // Step 4: Display results in the format number * i = result
        for (int i = 0; i < 4; i++) {
            int multiplier = 6 + i;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        sc.close();
    }
}
