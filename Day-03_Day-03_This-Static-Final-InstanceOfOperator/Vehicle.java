class Vehicle {
    static int registrationFee = 1000;
    private final String registrationNumber;
    private String ownerName, vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void updateRegistrationFee(int fee) {
        registrationFee = fee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("UP32AB1234", "Gaurav", "Car");
        Vehicle v2 = new Vehicle("UP32CD5678", "Neha", "Bike");

        updateRegistrationFee(1500);
        v1.displayDetails();
        v2.displayDetails();
    }
}
