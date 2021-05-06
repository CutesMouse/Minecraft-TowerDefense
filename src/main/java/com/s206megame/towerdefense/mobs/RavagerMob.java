package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.WitherSkeleton;

public class RavagerMob extends CraftMob {

    private Ravager ravager;
    private static final double MAX_HEALTH = 500.0;

    @Override
    public Entity getEntity() {
        return ravager;
    }

    @Override
    public String getMobName() {
        return "Ravager";
    }

    @Override
    public String getMobID() {
        return "ravager";
    }

    @Override
    public void spawn(Location loc) {
        Ravager entity = loc.getWorld().spawn(loc, Ravager.class);
        this.ravager = entity;
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

}