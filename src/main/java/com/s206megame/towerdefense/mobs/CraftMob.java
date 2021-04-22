package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.Map;
import org.bukkit.Location;

public abstract class CraftMob implements Mob {
    private static Map getMap() {
        return Main.map;
    }

    private double yaw;

    @Override
    public void moveMob(double distance) {
        double pi = (yaw - 90) * Math.PI / 180.0;
        double dx = -Math.cos(pi) * distance;
        double dz = -Math.sin(pi) * distance;
        Location c = getEntity().getLocation();
        double newX = c.getX() + dx;
        double newZ = c.getZ() + dz;
        double newY = c.getWorld().getHighestBlockAt((int) newX,(int) newZ).getLocation().getBlockY()+1;
        getEntity().teleport(new Location(c.getWorld(),newX,newY,newZ,(float) yaw,0));
    }


    @Override
    public void setFacingDegree(double yaw) {
        this.yaw = yaw;
    }
}
