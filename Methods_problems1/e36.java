import java.util.*;

public class NumberAnalyzer {
    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean isDuckNumber(int n) {
        String str = String.valueOf(n);
        return str.substring(1).contains("0");
    }

    public static boolean isArmstrong(int n) {
        int[] digits = getDigits(n);
        int power = digits.length;
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, power);
        return sum == n;
    }

    public static int[] findTwoLargest(int[] digits) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max) {
                second = max;
                max = d;
            } else if (d > second && d != max) {
                second = d;
            }
        }
        return new int[]{max, second};
    }

    public static int[] findTwoSmallest(int[] digits) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min) {
                second = min;
                min = d;
            } else if (d < second && d != min) {
                second = d;
            }
        }
        return new int[]{min, second};
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);

        System.out.println("Duck: " + isDuckNumber(number));
        System.out.println("Armstrong: " + isArmstrong(number));

        int[] max2 = findTwoLargest(digits);
        int[] min2 = findTwoSmallest(digits);
        System.out.println("Largest: " + max2[0] + ", Second Largest: " + max2[1]);
        System.out.println("Smallest: " + min2[0] + ", Second Smallest: " + min2[1]);
    }
}
