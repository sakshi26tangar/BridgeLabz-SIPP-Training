package com.smartcity.transport;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dashboard {
    public static void showLiveServices(List<TransportService> services) {
        System.out.println("=== Live Services ===");
        services.forEach(TransportService::printServiceDetails);
    }

    public static List<Schedule> findAvailableSchedules(List<TransportService> services, String fromName) {
        return services.stream()
                .flatMap(s -> s.getSchedules().stream())
                .filter(sc -> sc.getFrom().getName().equalsIgnoreCase(fromName))
                .sorted(Comparator.comparing(Schedule::getDeparture))
                .collect(Collectors.toList());
    }

    public static Map<String, List<Trip>> groupTripsByRoute(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(t -> t.getSchedule().getFrom().getName() + "->" + t.getSchedule().getTo().getName()));
    }

    public static Map<Boolean, List<Trip>> partitionPeakTrips(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.partitioningBy(Trip::isPeak));
    }

    public static void summarizeFares(List<Trip> trips) {
        java.util.DoubleSummaryStatistics stats = trips.stream()
                .collect(Collectors.summarizingDouble(Trip::getFare));
        System.out.println("Fares: count=" + stats.getCount() + " sum=" + stats.getSum() + " min=" + stats.getMin() + " max=" + stats.getMax() + " avg=" + stats.getAverage());
    }

    public static void printTopRoutes(List<Trip> trips, int topN) {
        System.out.println("=== Top Routes ===");
        Map<String, Long> counts = trips.stream()
                .collect(Collectors.groupingBy(t -> t.getSchedule().getFrom().getName() + "->" + t.getSchedule().getTo().getName(), Collectors.counting()));
        counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
