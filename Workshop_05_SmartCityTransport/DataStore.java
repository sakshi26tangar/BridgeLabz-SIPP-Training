package com.smartcity.transport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {
    public static List<TransportService> loadServices() {
        Location a = new Location("A", 28.7041, 77.1025);
        Location b = new Location("B", 28.5355, 77.3910);
        Location c = new Location("C", 28.4595, 77.0266);

        BusService bus = new BusService("BUS-100");
        bus.addSchedule(new Schedule("BUS-100-1", a, b, LocalDateTime.now().plusMinutes(15), 30));
        bus.addSchedule(new Schedule("BUS-100-2", b, c, LocalDateTime.now().plusMinutes(45), 45));

        MetroService metro = new MetroService("METRO-1");
        metro.addSchedule(new Schedule("METRO-1-1", a, c, LocalDateTime.now().plusMinutes(10), 50));

        TaxiService taxi = new TaxiService("TAXI-42");
        taxi.addSchedule(new Schedule("TAXI-42-1", a, b, LocalDateTime.now().plusMinutes(5), 120));

        AmbulanceService amb = new AmbulanceService("AMB-9");
        amb.addSchedule(new Schedule("AMB-9-1", b, a, LocalDateTime.now().plusMinutes(2), 0));

        return Arrays.<TransportService>asList(bus, metro, taxi, amb);
    }

    public static List<Passenger> samplePassengers() {
        return Arrays.asList(
                new Passenger("P1", "Alice"),
                new Passenger("P2", "Bob"),
                new Passenger("P3", "Carol")
        );
    }

    public static List<Trip> sampleTrips(List<TransportService> services) {
        List<Schedule> schedules = new ArrayList<>();
        services.forEach(s -> schedules.addAll(s.getSchedules()));
        List<Passenger> ps = samplePassengers();

        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip("T1", schedules.get(0), ps.get(0), LocalDateTime.now().minusMinutes(30), schedules.get(0).getBaseFare(), false));
        trips.add(new Trip("T2", schedules.get(1), ps.get(1), LocalDateTime.now().minusMinutes(20), schedules.get(1).getBaseFare()*1.1, true));
        trips.add(new Trip("T3", schedules.get(2), ps.get(2), LocalDateTime.now().minusMinutes(10), schedules.get(2).getBaseFare()*0.9, false));
        trips.add(new Trip("T4", schedules.get(3), ps.get(0), LocalDateTime.now().minusMinutes(5), 0, true));
        return trips;
    }
}
