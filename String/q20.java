import java.util.Scanner;

public class Q20_StudentGrades {
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + (int)(Math.random() * 61); // Physics
            scores[i][1] = 40 + (int)(Math.random() * 61); // Chemistry
            scores[i][2] = 40 + (int)(Math.random() * 61); // Math
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] result = new double[scores.length][3]; // total, avg, %
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] assignGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 90) grades[i] = "A";
            else if (p >= 80) grades[i] = "B";
            else if (p >= 70) grades[i] = "C";
            else if (p >= 60) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayReport(int[][] marks, double[][] stats, String[] grades) {
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-8s %-8s\n", "Phy", "Chem", "Math", "Total", "Avg", "Pct", "Grade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-8d %-8d %-8d %-8.0f %-8.2f %-8.2f %-8s\n",
                    marks[i][0], marks[i][1], marks[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] stats = calculateStats(scores);
        String[] grades = assignGrades(stats);
        displayReport(scores, stats, grades);
    }
}
