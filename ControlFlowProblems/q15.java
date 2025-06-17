import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(n + " is not a natural number.");
            return;
        }

        int sumFormula = n * (n + 1) / 2;

        int sumFor = 0;
        for (int i = 1; i <= n; i++) {
            sumFor += i;
        }

        System.out.println("Sum by formula   = " + sumFormula);
        System.out.println("Sum by for‑loop  = " + sumFor);
        System.out.println("Results match? " + (sumFormula == sumFor));
        sc.close();
    }
}
