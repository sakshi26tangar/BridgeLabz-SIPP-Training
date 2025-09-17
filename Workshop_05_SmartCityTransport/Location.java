package com.smartcity.transport;

public class Location {
    private final String name;
    private final double lat;
    private final double lon;

    public Location(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() { return name; }
    public double getLat() { return lat; }
    public double getLon() { return lon; }

    @Override
    public String toString() { return name + "(" + lat + "," + lon + ")"; }
}
