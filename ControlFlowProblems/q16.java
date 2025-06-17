import java.util.Scanner;

public class q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer (<100): ");
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Must be >0 and <100.");
            return;
        }

        System.out.println("Multiples of " + number + " below 100:");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
