import java.util.*;

public class MatrixAdvanced {
    public static int[][] createMatrix(int n) {
        int[][] mat = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    public static int[][] transpose(int[][] mat) {
        int n = mat.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                t[j][i] = mat[i][j];
        return t;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double) det;
        inv[0][1] = -m[0][1] / (double) det;
        inv[1][0] = -m[1][0] / (double) det;
        inv[1][1] = m[0][0] / (double) det;
        return inv;
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double val : row)
                System.out.printf("%.2f ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = createMatrix(2);
        System.out.println("Original:");
        printMatrix(mat);
        System.out.println("Transpose:");
        printMatrix(transpose(mat));
        System.out.println("Determinant: " + determinant2x2(mat));
        System.out.println("Inverse:");
        double[][] inv = inverse2x2(mat);
        if (inv != null)
            printMatrix(inv);
        else
            System.out.println("Inverse not possible (det=0)");
    }
}
