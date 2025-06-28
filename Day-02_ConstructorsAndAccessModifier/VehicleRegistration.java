public class VehicleRegistration {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5500.0;

    public VehicleRegistration(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Type: " + vehicleType +
                ", Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        VehicleRegistration v1 = new VehicleRegistration("Anita", "SUV");
        v1.displayVehicleDetails();
        VehicleRegistration.updateRegistrationFee(6000);
        VehicleRegistration v2 = new VehicleRegistration("Rohit", "Bike");
        v2.displayVehicleDetails();
    }
}
