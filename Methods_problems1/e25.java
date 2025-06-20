import java.util.Random;

public class FootballTeamStats {
    public static int sum(int[] arr) {
        int s = 0;
        for (int val : arr) s += val;
        return s;
    }

    public static int min(int[] arr) {
        int m = arr[0];
        for (int val : arr) if (val < m) m = val;
        return m;
    }

    public static int max(int[] arr) {
        int m = arr[0];
        for (int val : arr) if (val > m) m = val;
        return m;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();
        for (int i = 0; i < 11; i++)
            heights[i] = 150 + rand.nextInt(101); // 150 to 250

        int total = sum(heights);
        System.out.println("Heights: " + java.util.Arrays.toString(heights));
        System.out.println("Mean Height: " + (total / 11.0));
        System.out.println("Shortest: " + min(heights));
        System.out.println("Tallest: " + max(heights));
    }
}
