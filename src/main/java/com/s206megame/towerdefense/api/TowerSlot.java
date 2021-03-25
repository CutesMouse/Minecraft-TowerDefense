package com.s206megame.towerdefense.api;

import org.bukkit.Location;

import java.util.ArrayList;

public class TowerSlot {
    private Location loc;
    private TowerType type;

    public TowerSlot(Location loc, TowerType type) {
        this.loc = loc;
        this.type = type;
    }

    public boolean isInside(Location loc) {
        if (loc.getBlockY() != this.loc.getBlockY()) return false;
        int blockDiff = type.equals(TowerType.THREE_BY_THREE) ? 1 : 2;
        if (Math.abs(loc.getBlockX() - this.loc.getBlockX()) > blockDiff) return false;
        if (Math.abs(loc.getBlockZ() - this.loc.getBlockZ()) > blockDiff) return false;
        return true;
    }

    private ArrayList<Location> getBlockList() {
        int blockDiff = type.equals(TowerType.THREE_BY_THREE) ? 1 : 2;
        ArrayList<Location> locs = new ArrayList<>();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        for (int dx = -blockDiff; dx <= blockDiff; dx++) {
            for (int dz = -blockDiff; dz <= blockDiff; dz++) {
                locs.add(new Location(loc.getWorld(), x + dx, y, z + dz));
            }
        }
        return locs;
    }
}