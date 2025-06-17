import java.util.Scanner;

public class q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        System.out.println("Enter positive numbers (0 or negative to stop):");
        while (true) {
            double value = sc.nextDouble();
            if (value <= 0) break;
            total += value;
        }
        System.out.println("Total sum = " + total);
        sc.close();
    }
}
