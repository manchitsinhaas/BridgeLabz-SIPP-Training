import java.util.Scanner;

public class Q6_MaxOfThree {

    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];
        System.out.print("Enter three numbers: ");
        for (int i = 0; i < 3; i++) {
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] nums = getInput();
        int max = findMaximum(nums[0], nums[1], nums[2]);
        System.out.println("Maximum number is: " + max);
    }
}
