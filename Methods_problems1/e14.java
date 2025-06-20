import java.util.Scanner;

public class SumNaturalRecursive {
    public static int recursiveSum(int n) {
        if (n == 1) return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Not a natural number");
        } else {
            int sum1 = recursiveSum(n);
            int sum2 = formulaSum(n);
            System.out.println("Recursive sum: " + sum1);
            System.out.println("Formula sum: " + sum2);
            System.out.println("Equal: " + (sum1 == sum2));
        }
    }
}
