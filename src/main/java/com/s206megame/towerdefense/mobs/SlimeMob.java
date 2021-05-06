package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;

public class SlimeMob extends CraftMob {
    private Slime slime;
    private static final double MAX_HEALTH = 500.0;
    private double health = MAX_HEALTH;

    @Override
    public Entity getEntity() {
        return slime;
    }

    @Override
    public String getMobName() {
        return "Slime";
    }

    @Override
    public String getMobID() {
        return "slime";
    }

    @Override
    public void spawn(Location loc) {
        Slime entity = loc.getWorld().spawn(loc, Slime.class);
        entity.setSize(4);
        this.slime = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.05;
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