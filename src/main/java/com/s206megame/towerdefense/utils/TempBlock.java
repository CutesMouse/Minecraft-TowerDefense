package com.s206megame.towerdefense.utils;

import com.cutesmouse.mgui.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class TempBlock {
    private static HashMap<Player,HashMap<Location,Long>> estimate = new HashMap<>();
    public static void sendTempBlock(Player p, Material blockType, int tickLast, Location loc) {
        if (!estimate.containsKey(p)) estimate.put(p,new HashMap<>());
        estimate.get(p).put(loc,System.currentTimeMillis()+tickLast*20L);
        p.sendBlockChange(loc,blockType.createBlockData());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!p.isOnline()) return;
                if (estimate.get(p).get(loc) <= System.currentTimeMillis()) {
                    p.sendBlockChange(loc,loc.getBlock().getBlockData());
                }
            }
        }.runTaskLater(Main.getProvidingPlugin(Main.class),tickLast);
    }
}
