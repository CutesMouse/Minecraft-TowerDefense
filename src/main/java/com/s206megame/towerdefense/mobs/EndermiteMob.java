package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;

public class EndermiteMob extends CraftMob {

    private Endermite endermite;
    private static final double MAX_HEALTH = 500.0;

    @Override
    public Entity getEntity() {
        return endermite;
    }

    @Override
    public String getMobName() {
        return "Endermite";
    }

    @Override
    public String getMobID() {
        return "endermite";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Endermite entity = loc.getWorld().spawn(loc, Endermite.class);
        this.endermite = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.4 * strengthen_offset;
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
