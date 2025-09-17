package com.smartcity.transport;

import java.util.List;

public interface TransportService {
    String getId();
    String getType();
    List<Schedule> getSchedules();

    default void printServiceDetails() {
        System.out.println("Service: " + getId() + " (" + getType() + ")");
        getSchedules().forEach(s -> System.out.println("  " + s));
    }

    default boolean isEmergencyCapable() { return false; }
}
