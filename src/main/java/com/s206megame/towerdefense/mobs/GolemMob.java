package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Golem;
import org.bukkit.entity.IronGolem;

public class GolemMob extends CraftMob {
    private IronGolem golem;
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
    public double getTickPerBlock() {
        return 0.05;
    }
}
