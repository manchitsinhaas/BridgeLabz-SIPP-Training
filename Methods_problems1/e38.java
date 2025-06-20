import java.util.*;

public class CalendarDisplay {
    static String[] monthNames = {"January", "February", "March", "April", "May", "June",
                                  "July", "August", "September", "October", "November", "December"};
    static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getFirstDay(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + 31 * m / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int days = daysInMonth[month - 1];
        if (month == 2 && isLeapYear(year)) days = 29;

        int startDay = getFirstDay(month, year);
        System.out.println("     " + monthNames[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < startDay; i++)
            System.out.print("   ");
        for (int day = 1; day <= days; day++) {
            System.out.printf("%2d ", day);
            if ((day + startDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        displayCalendar(month, year);
    }
}
