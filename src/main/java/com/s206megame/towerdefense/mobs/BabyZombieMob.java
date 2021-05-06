package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;


public class BabyZombieMob extends CraftMob {
    private Zombie babyzombie;
    private static final double MAX_HEALTH = 50.0;

    @Override
    public Entity getEntity() {
        return babyzombie;
    }

    @Override
    public String getMobName() {
        return "Baby Zombie";
    }

    @Override
    public String getMobID() {
        return "babyzombie";
    }

    @Override
    public void spawn(Location loc) {
        Zombie entity = loc.getWorld().spawn(loc, Zombie.class);
        entity.setBaby();
        this.babyzombie = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.15;
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
