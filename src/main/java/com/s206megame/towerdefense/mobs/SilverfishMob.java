package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Silverfish;

public class SilverfishMob extends CraftMob {

    private Silverfish silverfish;
    private static final double MAX_HEALTH = 700.0;

    @Override
    public Entity getEntity() {
        return silverfish;
    }

    @Override
    public String getMobName() {
        return "Silverfish";
    }

    @Override
    public String getMobID() {
        return "silverfish";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Silverfish entity = loc.getWorld().spawn(loc, Silverfish.class);
        this.silverfish = entity;
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
