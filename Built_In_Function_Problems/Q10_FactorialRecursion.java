import java.util.Scanner;

public class Q10_FactorialRecursion {

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void displayResult(int n, long fact) {
        System.out.println("Factorial of " + n + " is: " + fact);
    }

    public static void main(String[] args) {
        int n = getInput();
        long fact = factorial(n);
        displayResult(n, fact);
    }
}
