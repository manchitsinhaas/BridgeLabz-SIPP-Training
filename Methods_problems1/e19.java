import java.util.Scanner;

public class NumberChecker {
    public static boolean isPositive(int n) {
        return n > 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
            if (isPositive(numbers[i])) {
                System.out.print("Positive and ");
                System.out.println(isEven(numbers[i]) ? "Even" : "Odd");
            } else {
                System.out.println("Negative");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        if (result == 0)
            System.out.println("First and last are equal");
        else if (result > 0)
            System.out.println("First is greater");
        else
            System.out.println("Last is greater");
    }
}
