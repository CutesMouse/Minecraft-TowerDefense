package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;

public interface Mob {
    String getMobName();
    String getMobID();
    void onEntityMove();
    void spawn(Location loc);
}
