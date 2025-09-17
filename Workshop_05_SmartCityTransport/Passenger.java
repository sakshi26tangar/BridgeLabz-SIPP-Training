package com.smartcity.transport;

public class Passenger {
    private final String id;
    private final String name;

    public Passenger(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() { return name + "(" + id + ")"; }
}
