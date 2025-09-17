package com.smartcity.transport;

public class FarePolicies {
    public static final FareCalculator DISTANCE_BASED = (schedule, km) -> {
        double base = schedule.getBaseFare();
        return base + km * 5.0;
    };

    public static double computeFareUsing(FareCalculator calc, Schedule s) {
        double dist = GeoUtils.calculateDistance(s.getFrom(), s.getTo());
        return calc.calculateFare(s, dist);
    }
}
