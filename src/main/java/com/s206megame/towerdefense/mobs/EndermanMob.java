package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.WitherSkeleton;

public class EndermanMob extends CraftMob {

    private Enderman enderman;
    private static final double MAX_HEALTH = 150.0;

    @Override
    public Entity getEntity() {
        return enderman;
    }

    @Override
    public String getMobName() {
        return "Enderman";
    }

    @Override
    public String getMobID() {
        return "enderman";
    }

    @Override
    public void spawn(Location loc) {
        Enderman entity = loc.getWorld().spawn(loc, Enderman.class);
        this.enderman = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.35;
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
