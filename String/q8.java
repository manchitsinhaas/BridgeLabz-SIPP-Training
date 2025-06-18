import java.util.Scanner;

public class Q8_SubstringCompare {
    public static String substringCustom(String input, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < input.length(); i++) {
            result += input.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String custom = substringCustom(input, start, end);
        String builtIn = input.substring(start, end);

        System.out.println("Custom Substring: " + custom);
        System.out.println("Built-in Substring: " + builtIn);
        System.out.println("Are they equal? " + compareStrings(custom, builtIn));
    }
}
