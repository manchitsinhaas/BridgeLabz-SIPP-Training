import java.util.Scanner;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String number, String type, double rate) {
        vehicleNumber = number;
        this.type = type;
        rentalRate = rate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate);
        this.policyNumber = policy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: " + policyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate);
        this.policyNumber = policy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 300;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: " + policyNumber;
    }
}

class Truck extends Vehicle {
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }
}

public class Q3_VehicleRentalSystem {
    public static void processRental(Vehicle v, int days) {
        System.out.println("\nVehicle: " + v.getType());
        System.out.println("Number: " + v.getVehicleNumber());
        System.out.println("Rental Cost: " + v.calculateRentalCost(days));
        if (v instanceof Insurable) {
            Insurable ins = (Insurable) v;
            System.out.println(ins.getInsuranceDetails());
            System.out.println("Insurance: " + ins.calculateInsurance());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3];

        System.out.print("Enter Car Number: ");
        String carNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double carRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Policy: ");
        String carPol = sc.nextLine();
        vehicles[0] = new Car(carNo, carRate, carPol);

        System.out.print("Enter Bike Number: ");
        String bikeNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double bikeRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Policy: ");
        String bikePol = sc.nextLine();
        vehicles[1] = new Bike(bikeNo, bikeRate, bikePol);

        System.out.print("Enter Truck Number: ");
        String truckNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double truckRate = sc.nextDouble();
        vehicles[2] = new Truck(truckNo, truckRate);

        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        for (Vehicle v : vehicles) {
            processRental(v, days);
        }
    }
}
