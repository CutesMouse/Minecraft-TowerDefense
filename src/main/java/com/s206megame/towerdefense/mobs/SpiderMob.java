package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Spider;

public class SpiderMob extends CraftMob {
    private Spider spider;
    private static final double MAX_HEALTH = 150.0;
    private double health = MAX_HEALTH;

    @Override
    public Entity getEntity() {
        return spider;
    }

    @Override
    public String getMobName() {
        return "Spider";
    }

    @Override
    public String getMobID() {
        return "spider";
    }

    @Override
    public void spawn(Location loc) {
        Spider entity = loc.getWorld().spawn(loc, Spider.class);
        this.spider = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 1/3;
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