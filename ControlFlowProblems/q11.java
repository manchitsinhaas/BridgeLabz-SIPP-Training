public class q11 {
    public static void main(String[] args) {
        /* pass month and day via command‑line, e.g. 3 21 */
        if (args.length < 2) {
            System.out.println("Usage: java SpringSeason <month> <day>");
            return;
        }
        int month = Integer.parseInt(args[0]);
        int day   = Integer.parseInt(args[1]);

        boolean isSpring =
                (month == 3 && day >= 20)  ||      // March 20‑31
                        (month == 4)               ||      // April
                        (month == 5)               ||      // May
                        (month == 6 && day <= 20);         // June 1‑20

        System.out.println(isSpring ? "Its a Spring Season" : "Not a Spring Season");
    }
}
