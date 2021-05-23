package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class BabyZombieMob extends CraftMob {
    private Zombie babyzombie;
    private static final double MAX_HEALTH = 400.0;

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
        entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Integer.MAX_VALUE,0,
                true,true));
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.35 * strengthen_offset;
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
