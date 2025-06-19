import java.util.Scanner;

public class FactorCalculator {

    public static int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int n : arr) s += n;
        return s;
    }

    public static int product(int[] arr) {
        int p = 1;
        for (int n : arr) p *= n;
        return p;
    }

    public static int sumOfSquares(int[] arr) {
        int s = 0;
        for (int n : arr) s += Math.pow(n, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] factors = getFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nSum of factors: " + sum(factors));
        System.out.println("Product of factors: " + product(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }
}
