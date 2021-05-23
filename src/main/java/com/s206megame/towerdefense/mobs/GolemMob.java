package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;

public class GolemMob extends CraftMob {
    private IronGolem golem;
    private static final double MAX_HEALTH = 2500.0;
    @Override
    public Entity getEntity() {
        return golem;
    }

    @Override
    public String getMobName() {
        return "Golem";
    }

    @Override
    public String getMobID() {
        return "golem";
    }

    @Override
    public void spawn(Location loc) {
        IronGolem entity = loc.getWorld().spawn(loc, IronGolem.class);
        this.golem = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.15 * strengthen_offset;
    }

    @Override
    public double getMaxHealth() {
        return 1000 * strengthen_offset;
    }

    @Override
    public double getHealth() {
        return health;
    }


}
