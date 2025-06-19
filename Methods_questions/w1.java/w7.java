import java.util.Scanner;

public class TrigFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double[] result = calculateTrigonometricFunctions(angle);
        System.out.printf("Sin: %.4f\nCos: %.4f\nTan: %.4f\n", result[0], result[1], result[2]);
    }
}
