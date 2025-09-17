package com.smartcity.transport;

@FunctionalInterface
public interface FareCalculator {
    double calculateFare(Schedule schedule, double distanceKm);
}
