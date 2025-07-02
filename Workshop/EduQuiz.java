public class EduQuizGrader {

    public static int calculateScore(String[] correctAnswers, String[] studentAnswers) {
        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        return score;
    }

    public static void main(String[] args) {
        // Example answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B"};
        String[] studentAnswers = {"a", "B", "d", "D", "A", "b", "C", "c", "A", "B"};

        int score = calculateScore(correctAnswers, studentAnswers);

        System.out.println("Total Score: " + score + " out of " + correctAnswers.length);
    }
}
