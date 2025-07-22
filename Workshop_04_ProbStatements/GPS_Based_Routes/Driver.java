public class Driver {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    public void addCheckpoint(Checkpoint cp) {
        routeHistory.addCheckpoint(cp);
    }

    public void printSummary() {
        System.out.println("Driver: " + driverId + " - " + name);
        System.out.println("Route Summary:");
        routeHistory.printRoute();
        double distance = routeHistory.computeTotalDistance();
        double penalty = routeHistory.computeTotalPenalty();
        double score = distance - penalty;
        boolean consistent = routeHistory.checkCriticalPoints();
        System.out.printf("Total Distance: %.1f km%n", distance);
        System.out.printf("Total Penalty: %.1f%n", penalty);
        System.out.printf("Route Score: %.1f%n", score);
        System.out.println("Critical Route Check: " +
            (consistent ? "All required checkpoints present" : "Missing critical checkpoints"));
    }
}

