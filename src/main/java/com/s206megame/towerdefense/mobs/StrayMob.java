package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Stray;

public class StrayMob extends CraftMob {

    private Stray stray;
    private static final double MAX_HEALTH = 600.0;

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
        currentLocation = loc;
        Stray entity = loc.getWorld().spawn(loc, Stray.class);
        this.stray = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.35 * strengthen_offset;
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
