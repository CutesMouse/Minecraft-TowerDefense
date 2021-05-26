package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.utils.HoveringText;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class ChickenJockeyMob extends CraftMob {
    private Chicken chicken;
    private Zombie zombie;
    private static final double MAX_HEALTH = 400.0;

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
        currentLocation = loc;
        chicken = loc.getWorld().spawn(loc, Chicken.class);
        zombie = loc.getWorld().spawn(loc, Zombie.class);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Integer.MAX_VALUE,0,
                true,true));
        zombie.setBaby();
        chicken.addPassenger(zombie);
        zombie.setAI(false);
        chicken.setAI(false);
        setFacingDegree(0);
    }

    public Zombie getZombie() {
        return zombie;
    }

    public Chicken getChicken() {
        return chicken;
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

    @Override
    public void kill() {
        zombie.remove();
        chicken.remove();
        alive = false;
        Random r = new Random();
        new HoveringText("+ " + (Math.round(getAward()*10)/10D),getEntity().getLocation()
                .add(r.nextDouble()* 2 - 1,r.nextDouble(),r.nextDouble() * 2 - 1),20);
        TowerDefense.getInstance().addMoney(getAward());
    }
}
