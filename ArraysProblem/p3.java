import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create array to store heights of 11 players
        double[] heights = new double[11];

        // Step 2: Get input from the user
        System.out.println("Enter the heights of 11 football players (in cm or meters):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Step 3: Calculate sum of heights
        double sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Step 4: Calculate mean
        double mean = sum / heights.length;

        // Step 5: Display result
        System.out.println("Mean height of the football team: " + mean);

        sc.close();
    }
}
