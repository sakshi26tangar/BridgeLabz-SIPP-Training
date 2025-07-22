public class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String id, String name, double dist, double expected, double actual) {
        super(id, name, dist, expected, actual);
    }

    public boolean isCritical() { return false; }

    public String getType() { return "RestCheckpoint"; }

    public double calculatePenalty() {
        return isDelayed() && (actualDuration - expectedDuration) > 30
                ? (actualDuration - expectedDuration) * 0.5
                : 0;
    }
}
