package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vindicator;

public class VindicatorMob extends CraftMob {
    private Vindicator vindicator;
    private static final double MAX_HEALTH = 250.0;

    @Override
    public Entity getEntity() {
        return vindicator;
    }

    @Override
    public String getMobName() {
        return "Vindicator";
    }

    @Override
    public String getMobID() {
        return "vindicator";
    }

    @Override
    public void spawn(Location loc) {
        Vindicator entity = loc.getWorld().spawn(loc, Vindicator.class);
        this.vindicator = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.1 * strengthen_offset;
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
