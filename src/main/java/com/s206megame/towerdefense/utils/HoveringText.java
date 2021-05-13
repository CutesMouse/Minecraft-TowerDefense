package com.s206megame.towerdefense.utils;

import com.cutesmouse.mgui.Main;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

public class HoveringText {
    private ArmorStand as;
    private String name;
    private Location loc;
    private int duration; // as ticks

    public HoveringText(String text, Location loc, int duration) {
        this.loc = loc;
        loc.getWorld().spawn(loc,ArmorStand.class,ar -> this.as = ar);
        as.setGravity(false);
        as.setMarker(true);
        as.setInvisible(true);
        as.setInvulnerable(true);
        as.setCustomName(text);
        as.setCustomNameVisible(true);
        this.name = text;
        this.duration = duration;
        registerDestroyer();

    }

    public void registerDestroyer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                as.remove();
            }
        }.runTaskLater(Main.getProvidingPlugin(Main.class),duration);
    }
}
