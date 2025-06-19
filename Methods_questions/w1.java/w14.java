import java.util.Scanner;

public class NaturalSumCompare {

    public static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        int sumRec = recursiveSum(n);
        int sumForm = formulaSum(n);
        System.out.println("Sum using recursion: " + sumRec);
        System.out.println("Sum using formula: " + sumForm);
        System.out.println("Both results match? " + (sumRec == sumForm));
    }
}
