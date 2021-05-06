package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;

public class MiniSlimeMob extends CraftMob {
    private Slime minislime;
    private static final double MAX_HEALTH = 125.0;
    private double health = MAX_HEALTH;

    @Override
    public Entity getEntity() {
        return minislime;
    }

    @Override
    public String getMobName() {
        return "MiniSlime";
    }

    @Override
    public String getMobID() {
        return "minislime";
    }

    @Override
    public void spawn(Location loc) {
        Slime entity = loc.getWorld().spawn(loc, Slime.class);
        entity.setSize(1);
        this.minislime = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.0125;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void damage(double point) {
        health -= point;
        if (health <= 0) kill();
    }

}