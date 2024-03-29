package com.s206megame.towerdefense.map.basic;

import com.s206megame.towerdefense.utils.MathTool;
import org.bukkit.Location;

public class CheckPoint {
    private Location loc;
    private double yaw;
    public CheckPoint(double x, double y, double z) {
        this.loc = new Location(null,x,y,z);
    }
    public void connectTo(CheckPoint point) {
        yaw = MathTool.locationToDegree(loc,point.loc);
    }
    public void connectTo(Location point) {
        yaw = MathTool.locationToDegree(loc,point);
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
