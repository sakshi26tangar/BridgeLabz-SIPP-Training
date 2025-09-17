package com.smartcity.transport;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<TransportService> services = DataStore.loadServices();
        List<Trip> trips = DataStore.sampleTrips(services);

        Dashboard.showLiveServices(services);

        System.out.println("\nAvailable schedules from A:");
        Dashboard.findAvailableSchedules(services, "A").forEach(System.out::println);

        System.out.println();
        Dashboard.summarizeFares(trips);
        Dashboard.printTopRoutes(trips, 3);

        System.out.println();
        Dashboard.partitionPeakTrips(trips).forEach((isPeak, list) -> System.out.println(isPeak + " -> " + list.size()));

        Schedule s = services.stream().flatMap(srv -> srv.getSchedules().stream()).findFirst().get();
        double fare = FarePolicies.computeFareUsing(FarePolicies.DISTANCE_BASED, s);
        System.out.println("Computed fare for " + s.getServiceId() + " = " + String.format("%.2f", fare));

        System.out.println();
        services.stream()
                .filter(srv -> srv instanceof EmergencyService)
                .forEach(srv -> System.out.println("EMERGENCY: " + srv.getId() + " is emergency-capable"));
    }
}
