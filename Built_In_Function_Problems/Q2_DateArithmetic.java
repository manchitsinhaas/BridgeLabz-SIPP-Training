import java.time.LocalDate;

public class Q2_DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2025, 6, 24); // example date

        LocalDate result = inputDate
                            .plusDays(7)
                            .plusMonths(1)
                            .plusYears(2)
                            .minusWeeks(3);

        System.out.println("Original Date: " + inputDate);
        System.out.println("Final Date after operations: " + result);
    }
}
