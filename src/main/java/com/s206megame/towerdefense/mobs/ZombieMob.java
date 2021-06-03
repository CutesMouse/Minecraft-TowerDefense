package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ZombieMob extends CraftMob {

    private Zombie zombie;
    private static final double MAX_HEALTH = 100.0;

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
        currentLocation = loc;
        Zombie entity = loc.getWorld().spawn(loc, Zombie.class);
        this.zombie = entity;
        entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Integer.MAX_VALUE,0,
                true,true));
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.15 * strengthen_offset;
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
