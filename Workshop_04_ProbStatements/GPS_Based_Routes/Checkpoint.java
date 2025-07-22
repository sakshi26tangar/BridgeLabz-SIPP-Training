public abstract class Checkpoint {
    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast;
    protected double expectedDuration;
    protected double actualDuration;

    public Checkpoint(String checkpointId, String locationName, double distanceFromLast,
                      double expectedDuration, double actualDuration) {
        this.checkpointId = checkpointId;
        this.locationName = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration = actualDuration;
    }

    public String getCheckpointId() { return checkpointId; }
    public String getLocationName() { return locationName; }
    public double getDistanceFromLast() { return distanceFromLast; }
    public boolean isDelayed() { return actualDuration > expectedDuration; }

    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();
}
