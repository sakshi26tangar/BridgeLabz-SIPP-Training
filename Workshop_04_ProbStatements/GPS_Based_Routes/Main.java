public class Main {
    public static void main(String[] args) {
        Driver d = new Driver("D1204", "Sakshi Tangar");

        d.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 30, 60, 70));
        d.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 20, 15, 15));
        d.addCheckpoint(new RestCheckpoint("C3", "Motel X", 40, 60, 95));
        d.addCheckpoint(new DeliveryCheckpoint("C4", "Client Hub", 30, 45, 60));

        d.printSummary();
    }
}
