package com.s206megame.towerdefense.utils;

import com.cutesmouse.mgui.Main;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class HoveringText {
    private static ArrayList<ArmorStand> EXISTED = new ArrayList<>();
    private ArmorStand as;
    private String name;
    private Location loc;
    private int duration; // as ticks

    public static void clear() {
        for (ArmorStand as : EXISTED) {
            as.remove();
        }
    }

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
        EXISTED.add(as);

    }

    public void registerDestroyer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                as.remove();
                EXISTED.remove(as);
            }
        }.runTaskLater(Main.getProvidingPlugin(Main.class),duration);
    }
}
