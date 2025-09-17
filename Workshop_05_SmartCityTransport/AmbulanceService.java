package com.smartcity.transport;

import java.util.ArrayList;
import java.util.List;

public class AmbulanceService implements TransportService, EmergencyService {
    private final String id;
    private final List<Schedule> schedules = new ArrayList<>();

    public AmbulanceService(String id) { this.id = id; }
    public void addSchedule(Schedule s) { schedules.add(s); }

    @Override
    public String getId() { return id; }

    @Override
    public String getType() { return "AMBULANCE"; }

    @Override
    public List<Schedule> getSchedules() { return schedules; }

    @Override
    public boolean isEmergencyCapable() { return true; }
}
