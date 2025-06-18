import java.util.Scanner;

public class Q19_StringLength {
    public static int getLength(String input) {
        int count = 0;
        try {
            while (true) {
                input.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.next();

        System.out.println("Custom Length: " + getLength(input));
        System.out.println("Built-in Length: " + input.length());
    }
}
