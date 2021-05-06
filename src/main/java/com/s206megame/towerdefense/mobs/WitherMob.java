package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;

public class WitherMob extends CraftMob {

    private Wither wither;
    private static final double MAX_HEALTH = 2500.0;

    @Override
    public Entity getEntity() {
        return wither;
    }

    @Override
    public String getMobName() {
        return "Wither";
    }

    @Override
    public String getMobID() {
        return "wither";
    }

    @Override
    public void spawn(Location loc) {
        Wither entity = loc.getWorld().spawn(loc, Wither.class);
        this.wither = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.075;
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