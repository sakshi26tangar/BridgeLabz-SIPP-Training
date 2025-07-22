public class DeliveryCheckpoint extends Checkpoint {
    public DeliveryCheckpoint(String id, String name, double dist, double expected, double actual) {
        super(id, name, dist, expected, actual);
    }

    public boolean isCritical() { return true; }

    public String getType() { return "DeliveryCheckpoint"; }

    public double calculatePenalty() {
        return isDelayed() ? (actualDuration - expectedDuration) * 2 : 0;
    }
}
