import java.util.*;

public class DigitUtility {
    public static int[] getDigits(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int sumOfDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    public static int sumOfSquares(int[] digits) {
        return Arrays.stream(digits).map(d -> d * d).sum();
    }

    public static boolean isHarshad(int n) {
        int[] d = getDigits(n);
        return n % sumOfDigits(d) == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            if (freq[i] > 0) list.add(new int[]{i, freq[i]});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int num = 378;
        int[] digits = getDigits(num);
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Is Harshad: " + isHarshad(num));

        int[][] freq = digitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] row : freq) {
            System.out.println("Digit: " + row[0] + ", Frequency: " + row[1]);
        }
    }
}
