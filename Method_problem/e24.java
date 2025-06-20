import java.util.Arrays;

public class NumberChecker1 {
    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = arr.clone();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int t = rev[i];
            rev[i] = rev[j];
            rev[j] = t;
        }
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int n) {
        int[] d = getDigits(n);
        return arraysEqual(d, reverseArray(d));
    }

    public static boolean isDuckNumber(int n) {
        int[] d = getDigits(n);
        for (int i = 1; i < d.length; i++)
            if (d[i] == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int number = 12021;
        System.out.println("Palindrome: " + isPalindrome(number));
        System.out.println("Duck Number: " + isDuckNumber(number));
    }
}
