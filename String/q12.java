import java.util.Scanner;

public class Q12_SplitWordsLength {
    public static String[] customSplit(String input) {
        input = input.trim() + " "; // Ensure one space at end
        String word = "";
        java.util.ArrayList<String> words = new java.util.ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') word += ch;
            else if (!word.isEmpty()) {
                words.add(word);
                word = "";
            }
        }
        return words.toArray(new String[0]);
    }

    public static int getLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-15s %-10s\n", "Word", "Length");
        for (String[] row : table) {
            System.out.printf("%-15s %-10s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] table = getWordLengths(words);
        displayTable(table);
    }
}
