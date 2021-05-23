package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;

public class SlimeMob extends CraftMob {
    private Slime slime;
    private static final double MAX_HEALTH = 500.0;

    public SlimeMob() {
        super();
    }

    @Override
    public Entity getEntity() {
        return slime;
    }

    @Override
    public String getMobName() {
        return "Slime";
    }

    @Override
    public String getMobID() {
        return "slime";
    }

    @Override
    public void spawn(Location loc) {
        Slime entity = loc.getWorld().spawn(loc, Slime.class);
        entity.setSize(4);
        this.slime = entity;
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
