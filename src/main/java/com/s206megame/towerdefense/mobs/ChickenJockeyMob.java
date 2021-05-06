package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;

public class ChickenJockeyMob extends CraftMob {
    private Chicken chicken;
    private Zombie zombie;
    private static final double MAX_HEALTH = 150.0;

    @Override
    public Entity getEntity() {
        return chicken;
    }

    @Override
    public String getMobName() {
        return "Chicken Jockey";
    }

    @Override
    public String getMobID() {
        return "chickenjockey";
    }

    @Override
    public void spawn(Location loc) {
        Chicken entity1 = loc.getWorld().spawn(loc, Chicken.class);
        Zombie entity2 = loc.getWorld().spawn(loc, Zombie.class);
        zombie.setBaby();
        this.chicken = entity1;
        this.zombie = entity2;
        entity1.addPassenger(zombie);
        entity1.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getTickPerBlock() {
        return 0.25;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void kill() {
        super.kill();
    }
}
