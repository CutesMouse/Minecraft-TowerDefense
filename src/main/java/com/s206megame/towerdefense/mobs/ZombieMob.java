package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;

public class ZombieMob extends CraftMob {

    private Zombie zombie;

    @Override
    public Entity getEntity() {
        return zombie;
    }

    @Override
    public String getMobName() {
        return "Zombie";
    }

    @Override
    public String getMobID() {
        return "zombie";
    }

    @Override
    public void spawn(Location loc) {
        Zombie entity = loc.getWorld().spawn(loc, Zombie.class);
        this.zombie = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.05;
    }
}
