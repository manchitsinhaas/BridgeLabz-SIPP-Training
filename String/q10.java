import java.util.Scanner;

public class Q10_ToCharArray {
    public static char[] customToCharArray(String input) {
        char[] arr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] custom = customToCharArray(input);
        char[] builtin = input.toCharArray();

        System.out.println("Custom toCharArray: " + new String(custom));
        System.out.println("Built-in toCharArray: " + new String(builtin));
        System.out.println("Are they equal? " + compareArrays(custom, builtin));
    }
}
