package com.s206megame.towerdefense.api;

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
    public boolean isPassBy(Location loc) {
        this.loc.setWorld(loc.getWorld());
        return loc.distance(this.loc) < 0.4;
    }
    public boolean isPassBy(Location loc,double def) {
        this.loc.setWorld(loc.getWorld());
        return loc.distance(this.loc) < def;
    }

    public double getYaw() {
        return yaw;
    }
}
