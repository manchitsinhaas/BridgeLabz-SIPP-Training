import java.util.Scanner;

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public void assignDepartment(String deptName) {
        department = deptName;
    }

    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

public class Q1_EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[2];

        System.out.print("Enter Full-Time Employee ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Base Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept1 = sc.nextLine();
        FullTimeEmployee ft = new FullTimeEmployee(id1, name1, salary, bonus);
        ft.assignDepartment(dept1);

        System.out.print("\nEnter Part-Time Employee ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Hourly Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Hours Worked: ");
        int hours = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept2 = sc.nextLine();
        PartTimeEmployee pt = new PartTimeEmployee(id2, name2, rate, hours);
        pt.assignDepartment(dept2);

        employees[0] = ft;
        employees[1] = pt;

        for (Employee e : employees) {
            e.displayDetails();
            if (e instanceof Department) {
                System.out.println(((Department) e).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}
