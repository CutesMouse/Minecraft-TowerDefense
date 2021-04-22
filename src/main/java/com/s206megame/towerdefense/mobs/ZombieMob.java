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
        entity.setAI(false);
        move(entity);
    }

    private void move(Entity entity) {
        new BukkitRunnable() {
            int times = 0;
            @Override
            public void run() {
                if (times == 80) {
                    this.cancel();
                    return;
                }
                entity.teleport(entity.getLocation().clone().add(0,0,0.1));
                times++;
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,1L);
    }
}
