import java.util.Scanner;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per KM: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

public class Q8_RideHailingApplication {
    public static void processRide(Vehicle v, double distance) {
        v.getVehicleDetails();
        if (v instanceof GPS) {
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
        }
        System.out.println("Fare for " + distance + " KM: ₹" + v.calculateFare(distance));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] rides = new Vehicle[3];

        System.out.print("Enter Car ID: ");
        String carId = sc.nextLine();
        System.out.print("Driver: ");
        String carDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double carRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String carLoc = sc.nextLine();
        rides[0] = new Car(carId, carDriver, carRate, carLoc);

        System.out.print("\nEnter Bike ID: ");
        String bikeId = sc.nextLine();
        System.out.print("Driver: ");
        String bikeDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double bikeRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String bikeLoc = sc.nextLine();
        rides[1] = new Bike(bikeId, bikeDriver, bikeRate, bikeLoc);

        System.out.print("\nEnter Auto ID: ");
        String autoId = sc.nextLine();
        System.out.print("Driver: ");
        String autoDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double autoRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String autoLoc = sc.nextLine();
        rides[2] = new Auto(autoId, autoDriver, autoRate, autoLoc);

        System.out.print("\nEnter ride distance in KM: ");
        double distance = sc.nextDouble();

        for (Vehicle v : rides) {
            processRide(v, distance);
        }
    }
}
