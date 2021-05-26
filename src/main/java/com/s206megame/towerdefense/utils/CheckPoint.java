package com.s206megame.towerdefense.utils;

import org.bukkit.Location;

public class CheckPoint {
    private Location loc;
    private double yaw;
    public CheckPoint(Location loc, double yaw) {
        this.yaw = yaw;
        this.loc = loc;
    }
    public CheckPoint(double x, double y, double z, double yaw) {
        this.yaw = yaw;
        this.loc = new Location(null,x,y,z);
    }
    public CheckPoint(double x, double y, double z) {
        this.loc = new Location(null,x,y,z);
    }
    public void connectTo(CheckPoint point) {
        yaw = MathTool.locationToDegree(loc,point.loc);
    }
    public void connectTo(Location point) {
        yaw = MathTool.locationToDegree(loc,point);
    }
    public boolean isPassBy(Location loc) {
        this.loc.setWorld(loc.getWorld());
        return distance(loc,this.loc) < 0.4;
    }
    private double distance(Location loc1, Location loc2) {
        double x1 = loc1.getX();
        double z1 = loc1.getZ();
        double x2 = loc2.getX();
        double z2 = loc2.getZ();
        double dx = x1 - x2;
        double dz = z1 - z2;
        return Math.sqrt(dx * dx + dz * dz);
    }

    public boolean isPassBy(Location loc,double def) {
        this.loc.setWorld(loc.getWorld());
        return distance(loc,this.loc) < def;
    }

    public double getYaw() {
        return yaw;
    }
}
