package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Zombie;

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


    }
}
