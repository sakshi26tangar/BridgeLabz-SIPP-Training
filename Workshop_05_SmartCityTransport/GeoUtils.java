package com.smartcity.transport;

public interface GeoUtils {
    static double calculateDistance(Location a, Location b) {
        double R = 6371e3;
        double phi1 = Math.toRadians(a.getLat());
        double phi2 = Math.toRadians(b.getLat());
        double dphi = Math.toRadians(b.getLat() - a.getLat());
        double dlambda = Math.toRadians(b.getLon() - a.getLon());

        double sa = Math.sin(dphi/2) * Math.sin(dphi/2) +
                Math.cos(phi1) * Math.cos(phi2) * Math.sin(dlambda/2) * Math.sin(dlambda/2);
        double c = 2 * Math.atan2(Math.sqrt(sa), Math.sqrt(1-sa));
        double d = R * c;
        return d/1000.0;
    }
}
