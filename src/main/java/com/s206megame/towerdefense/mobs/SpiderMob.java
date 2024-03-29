package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Spider;

public class SpiderMob extends CraftMob {
    private Spider spider;
    private static final double MAX_HEALTH = 200.0;

    @Override
    public Entity getEntity() {
        return spider;
    }

    @Override
    public String getMobName() {
        return "Spider";
    }

    @Override
    public String getMobID() {
        return "spider";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Spider entity = loc.getWorld().spawn(loc, Spider.class);
        this.spider = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.2 * strengthen_offset;
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
