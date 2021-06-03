package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;

public class BlazeMob extends CraftMob {

    private Blaze blaze;
    private static final double MAX_HEALTH = 800.0;

    @Override
    public Entity getEntity() {
        return blaze;
    }

    @Override
    public String getMobName() {
        return "Blaze";
    }

    @Override
    public String getMobID() {
        return "blaze";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Blaze entity = loc.getWorld().spawn(loc, Blaze.class);
        this.blaze = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.25 * strengthen_offset;
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
