package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;


public class SmallSlimeMob extends CraftMob {
    private Slime smallslime;
    private static final double MAX_HEALTH = 125.0;

    @Override
    public Entity getEntity() {
        return smallslime;
    }

    @Override
    public String getMobName() {
        return "Small Slime";
    }

    @Override
    public String getMobID() {
        return "smallslime";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Slime entity = loc.getWorld().spawn(loc, Slime.class);
        entity.setSize(2);
        this.smallslime = entity;
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
