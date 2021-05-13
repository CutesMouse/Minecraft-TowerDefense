package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.effect.MobEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.ArrayList;

public interface Mob {
    boolean isOnFire();
    void setOnFire(boolean t);
    Entity getEntity();
    String getMobName();
    String getMobID();
    void onEntityMove();
    void spawn(Location loc);
    void moveMob(double distance);
    void setFacingDegree(double yaw);
    double getBlockPerTick();
    void updateDisplayName();
    double getMaxHealth();
    double getHealth();
    void kill();
    void damage(double point);
    ArrayList<MobEffect> getEffects();
    void addEffect(MobEffect ef);
    void effectUpdate();
    double getAward();
    double getYoffset();
    void waveEffect(int wave);
}
