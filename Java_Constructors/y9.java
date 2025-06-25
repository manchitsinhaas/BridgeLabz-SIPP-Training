public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 5000;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println(ownerName + " owns a " + vehicleType + ", Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}
