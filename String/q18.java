import java.util.Scanner;

public class Q18_AgeVoting {
    public static int[] getRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + (int)(Math.random() * 50); // Age between 10-59
        }
        return ages;
    }

    public static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = (ages[i] >= 18 ? "true" : "false");
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-10s\n", "Age", "Can Vote");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = getRandomAges(10);
        String[][] result = canVote(ages);
        displayTable(result);
    }
}
