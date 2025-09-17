package com.smartcity.transport;

import java.time.LocalDateTime;

public class Schedule {
    private final String serviceId;
    private final Location from;
    private final Location to;
    private final LocalDateTime departure;
    private final double baseFare;

    public Schedule(String serviceId, Location from, Location to, LocalDateTime departure, double baseFare) {
        this.serviceId = serviceId;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.baseFare = baseFare;
    }

    public String getServiceId() { return serviceId; }
    public Location getFrom() { return from; }
    public Location getTo() { return to; }
    public LocalDateTime getDeparture() { return departure; }
    public double getBaseFare() { return baseFare; }

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s @ %s (fare=%.2f)", serviceId, from.getName(), to.getName(), departure, baseFare);
    }
}
