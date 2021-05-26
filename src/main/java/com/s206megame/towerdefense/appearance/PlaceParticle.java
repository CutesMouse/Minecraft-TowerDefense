package com.s206megame.towerdefense.appearance;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.utils.TempBlock;
import com.s206megame.towerdefense.utils.TowerSlot;
import com.s206megame.towerdefense.player.PlayerDataManager;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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
                    if (!p.getInventory().getItemInMainHand().getType().equals(Material.ARMOR_STAND)) {
                        PlayerDataManager.getPlayerData(p).setSlot(null);
                        continue;
                    }
                    Block tb = p.getTargetBlockExact(100);
                    if (tb == null) {
                        PlayerDataManager.getPlayerData(p).setSlot(null);
                        continue;
                    }
                    TowerSlot tower = Main.map.identifyTower(tb.getLocation());
                    if (tower == null) {
                        PlayerDataManager.getPlayerData(p).setSlot(null);
                        continue;
                    }
                    ParticleManager.playParticle(p.getEyeLocation(),
                            p.getEyeLocation().getDirection(),tb.getLocation().distance(p.getEyeLocation()),1, Particle.SPELL_WITCH);
                    for (Location loc : tower.getOutline()) {
                        TempBlock.sendTempBlock(p,Material.GLOWSTONE,3,loc);
                    }
                    PlayerDataManager.getPlayerData(p).setSlot(tower);
                }
            }
        }.runTaskTimer(m,20L,3L);
    }
}
