package com.s206megame.towerdefense.mobs.basic;

import com.s206megame.towerdefense.effect.MobEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.ArrayList;

public interface Mob {
    double getMaxHealth();

    double getBlockPerTick();

    double getAward();

    Location getCurrentLocation();

    double getHealth();

    double getFacingDegree();

    ArrayList<MobEffect> getEffects();

    void strengthen(int l);

    boolean isOnFire();
    void setOnFire(boolean t);
    Entity getEntity();
    String getMobName();
    String getMobID();
    void onEntityMove();
    void spawn(Location loc);
    void moveMob(double distance);
    void setFacingDegree(double yaw);
    void setSlowness(double ratio);
    void updateDisplayName();
    void kill();
    void damage(double point);
    void addEffect(MobEffect ef);
    void effectUpdate();
    double getYoffset();
    boolean isAlive();
}
