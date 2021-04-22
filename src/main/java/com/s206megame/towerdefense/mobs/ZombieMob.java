package com.s206megame.towerdefense.mobs;

import com.cutesmouse.mgui.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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
    public void onEntityMove() {

    }

    @Override
    public void spawn(Location loc) {
        Zombie entity = loc.getWorld().spawn(loc, Zombie.class);
        this.zombie = entity;
        entity.setAI(false);
        setFacingDegree(0);
        move();
    }

    private void move() {
        new BukkitRunnable() {
            Location p1 = new Location(zombie.getWorld(), -46, 5 , -10.5);
            Location p2 = new Location(zombie.getWorld(), -26,5,-10.234);
            Location p3 = new Location(zombie.getWorld(), -25.903,5,1.5);
            int sec = 0;
            @Override
            public void run() {
                if (getEntity().isDead()) {
                    this.cancel();
                    return;
                }
                moveMob(0.2);
                if (p1.distance(getEntity().getLocation()) < 1) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage("set!");
                    }
                    setFacingDegree(-85.8);
                }
                if (p2.distance(getEntity().getLocation()) < 1) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage("set!");
                    }
                    setFacingDegree(0);
                }
                if (p3.distance(getEntity().getLocation()) < 1) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage("set!");
                    }
                    setFacingDegree(79.8);
                }
                sec++;
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,1L);
    }
}
