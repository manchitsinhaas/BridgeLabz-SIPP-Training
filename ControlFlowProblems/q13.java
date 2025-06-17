import java.util.Scanner;

public class q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        boolean divisible = (number % 5 == 0);
        System.out.println("Is the number " + number + " divisible by 5? " + divisible);
        sc.close();
    }
}
