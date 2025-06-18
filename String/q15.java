import java.util.Scanner;

public class Q15_ShortestLongestWord {
    public static String[] customSplit(String input) {
        input = input.trim() + " ";
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

    public static int[] findMinMax(String[] words) {
        int min = getLength(words[0]);
        int max = getLength(words[0]);
        for (String word : words) {
            int len = getLength(word);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        int[] minMax = findMinMax(words);

        System.out.println("Shortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
    }
}
