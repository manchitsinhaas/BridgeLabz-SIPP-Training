public class EmployeeBonus {
    public static void main(String[] args) {
        int[][] data = new int[10][2]; // [salary, years]
        double[][] newData = new double[10][2]; // [new salary, bonus]
        int oldSum = 0;
        double newSum = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000); // salary
            data[i][1] = 1 + (int)(Math.random() * 10); // years
            oldSum += data[i][0];

            double bonus = data[i][1] > 5 ? data[i][0] * 0.05 : data[i][0] * 0.02;
            newData[i][1] = bonus;
            newData[i][0] = data[i][0] + bonus;

            newSum += newData[i][0];
            totalBonus += bonus;
        }

        System.out.println("Emp\tOld\tYears\tBonus\tNew");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n", i+1, data[i][0], data[i][1], newData[i][1], newData[i][0]);
        }

        System.out.printf("Total Old Salary: %d\n", oldSum);
        System.out.printf("Total New Salary: %.2f\n", newSum);
        System.out.printf("Total Bonus Paid: %.2f\n", totalBonus);
    }
}
