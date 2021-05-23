package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Stray;
import org.bukkit.entity.WitherSkeleton;

public class StrayMob extends CraftMob {

    private Stray stray;
    private static final double MAX_HEALTH = 400.0;

    @Override
    public Entity getEntity() {
        return stray;
    }

    @Override
    public String getMobName() {
        return "Stray";
    }

    @Override
    public String getMobID() {
        return "stray";
    }

    @Override
    public void spawn(Location loc) {
        Stray entity = loc.getWorld().spawn(loc, Stray.class);
        this.stray = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.45 * strengthen_offset;
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
