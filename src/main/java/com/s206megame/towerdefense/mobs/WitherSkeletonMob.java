package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;

public class WitherSkeletonMob extends CraftMob {

    private WitherSkeleton witherskeleton;
    private static final double MAX_HEALTH = 700.0;

    @Override
    public Entity getEntity() {
        return witherskeleton;
    }

    @Override
    public String getMobName() {
        return "Wither Skeleton";
    }

    @Override
    public String getMobID() {
        return "witherskeleton";
    }

    @Override
    public void spawn(Location loc) {
        WitherSkeleton entity = loc.getWorld().spawn(loc, WitherSkeleton.class);
        this.witherskeleton = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.2 * strengthen_offset;
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
