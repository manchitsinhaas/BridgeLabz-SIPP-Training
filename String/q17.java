import java.util.Scanner;

public class Q17_SplitCompare {
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

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] custom = customSplit(input);
        String[] builtin = input.trim().split("\\s+");

        System.out.println("Custom split: " + java.util.Arrays.toString(custom));
        System.out.println("Built-in split: " + java.util.Arrays.toString(builtin));
        System.out.println("Are they equal? " + compareArrays(custom, builtin));
    }
}
