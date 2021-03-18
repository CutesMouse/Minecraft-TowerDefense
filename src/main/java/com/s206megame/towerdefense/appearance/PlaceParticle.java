package com.s206megame.towerdefense.appearance;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.TempBlock;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaceParticle {
    public static void init(Main m) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.getInventory().getItemInMainHand().getType().equals(Material.ARMOR_STAND)) continue;
                    Block tb = p.getTargetBlockExact(100);
                    if (tb == null) continue;
                    ParticleManager.playParticle(p.getEyeLocation(),
                            p.getEyeLocation().getDirection(),100,0.5, Particle.CRIT_MAGIC);
                    TempBlock.sendTempBlock(p,Material.GOLD_BLOCK,20,tb.getLocation());
                }
            }
        }.runTaskTimer(m,20L,10L);
    }
}
