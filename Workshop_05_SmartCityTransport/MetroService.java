package com.smartcity.transport;

import java.util.ArrayList;
import java.util.List;

public class MetroService implements TransportService {
    private final String id;
    private final List<Schedule> schedules = new ArrayList<>();

    public MetroService(String id) { this.id = id; }
    public void addSchedule(Schedule s) { schedules.add(s); }

    @Override
    public String getId() { return id; }

    @Override
    public String getType() { return "METRO"; }

    @Override
    public List<Schedule> getSchedules() { return schedules; }
}
