public class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String id, String name, double dist, double expected, double actual) {
        super(id, name, dist, expected, actual);
    }

    public boolean isCritical() { return true; }

    public String getType() { return "FuelCheckpoint"; }

    public double calculatePenalty() {
        return isDelayed() ? 10.0 : 0;
    }
}
