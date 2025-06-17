import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        System.out.println("Enter numbers (0 to stop):");
        double input = sc.nextDouble();

        while (input != 0) {
            total += input;
            input = sc.nextDouble();
        }

        System.out.println("Total sum: " + total);
        sc.close();
    }
}
