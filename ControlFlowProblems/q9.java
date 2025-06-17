import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(n + " is not a natural number.");
            return;
        }

        /*––– sum with formula –––*/
        int sumFormula = n * (n + 1) / 2;

        /*––– sum with while loop –––*/
        int sumWhile = 0, i = 1;
        while (i <= n) {
            sumWhile += i;
            i++;
        }

        System.out.println("Sum by formula      = " + sumFormula);
        System.out.println("Sum by while‑loop   = " + sumWhile);
        System.out.println("Results match? " + (sumFormula == sumWhile));
        sc.close();
    }
}
