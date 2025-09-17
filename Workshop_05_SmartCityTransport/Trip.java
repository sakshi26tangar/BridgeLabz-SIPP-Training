package com.smartcity.transport;

import java.time.LocalDateTime;

public class Trip {
    private final String tripId;
    private final Schedule schedule;
    private final Passenger passenger;
    private final LocalDateTime bookedAt;
    private final double fare;
    private final boolean peak;

    public Trip(String tripId, Schedule schedule, Passenger passenger, LocalDateTime bookedAt, double fare, boolean peak) {
        this.tripId = tripId;
        this.schedule = schedule;
        this.passenger = passenger;
        this.bookedAt = bookedAt;
        this.fare = fare;
        this.peak = peak;
    }

    public String getTripId() { return tripId; }
    public Schedule getSchedule() { return schedule; }
    public Passenger getPassenger() { return passenger; }
    public LocalDateTime getBookedAt() { return bookedAt; }
    public double getFare() { return fare; }
    public boolean isPeak() { return peak; }

    @Override
    public String toString() {
        return String.format("Trip[%s] %s -> %s for %s fare=%.2f peak=%b",
                tripId, schedule.getFrom().getName(), schedule.getTo().getName(), passenger.getName(), fare, peak);
    }
}
