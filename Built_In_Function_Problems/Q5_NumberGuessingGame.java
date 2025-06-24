import java.util.Scanner;
import java.util.Random;

public class Q5_NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getUserFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (enter: low / high / correct): ");
        return sc.next().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback = "";

        while (!feedback.equals("correct") && low <= high) {
            int guess = generateGuess(low, high);
            feedback = getUserFeedback(sc, guess);

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (!feedback.equals("correct")) {
                System.out.println("Invalid input. Please enter: low, high, or correct.");
            }
        }

        if (feedback.equals("correct")) {
            System.out.println("Hooray! I guessed your number!");
        } else {
            System.out.println("Something went wrong. Are you sure you followed the rules?");
        }
    }
}
