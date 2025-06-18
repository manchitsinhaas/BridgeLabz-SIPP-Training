import java.util.Scanner;

public class Q11_VowelConsonant {
    public static String classifyChar(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyzeText(String input) {
        String[][] result = new String[input.length()][2];
        for (int i = 0; i < input.length(); i++) {
            result[i][0] = input.charAt(i) + "";
            result[i][1] = classifyChar(input.charAt(i));
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-15s\n", "Character", "Type");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = analyzeText(input);
        displayTable(result);
    }
}
