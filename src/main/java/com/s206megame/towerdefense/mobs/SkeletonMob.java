package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;


public class SkeletonMob extends CraftMob {

    private Skeleton skeleton;
    private static final double MAX_HEALTH = 150.0;

    @Override
    public Entity getEntity() {
        return skeleton;
    }

    @Override
    public String getMobName() {
        return "Skeleton";
    }

    @Override
    public String getMobID() {
        return "skeleton";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Skeleton entity = loc.getWorld().spawn(loc, Skeleton.class);
        this.skeleton = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.15 * strengthen_offset;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH * strengthen_offset;
    }

    @Override
    public double getHealth() {
        return health;
    }

}
