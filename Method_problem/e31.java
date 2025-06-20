import java.util.*;

public class StudentScorecard {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3]; // PCM
        Random rand = new Random();
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 40 + rand.nextInt(61); // Random score between 40-100
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        int students = scores.length;
        double[][] result = new double[students][3]; // total, avg, percent
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\t");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n", i + 1,
                scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);
    }
}
