import java.time.LocalDate;

public class Q4_DateComparison {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2025, 6, 24);
        LocalDate date2 = LocalDate.of(2026, 1, 1);

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        } else {
            System.out.println("Date1 is equal to Date2");
        }
    }
}
