package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface Mob {
    boolean isPoisoned = false;
    boolean isOnFire = false;
    Entity getEntity();
    String getMobName();
    String getMobID();
    void onEntityMove();
    void spawn(Location loc);
    void moveMob(double distance);
    void setFacingDegree(double yaw);
    double getTickPerBlock();
    void updateDisplayName();
    double getMaxHealth();
    double getHealth();
    void kill();
    void damage(double point);
}
