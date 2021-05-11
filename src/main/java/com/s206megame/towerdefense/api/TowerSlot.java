package com.s206megame.towerdefense.api;

import com.s206megame.towerdefense.tower.Direction;
import org.bukkit.Location;

import java.util.ArrayList;

public class TowerSlot {
    private Location loc;
    private TowerType type;
    private Direction outDirection;

    public TowerSlot(Location loc, TowerType type, Direction outDirection) {
        this.loc = loc;
        this.type = type;
        this.outDirection = outDirection;
    }

    public boolean isInside(Location loc) {
        if (loc.getBlockY() < this.loc.getBlockY()) return false;
        int blockDiff = type.equals(TowerType.THREE_BY_THREE) ? 1 : 2;
        if (Math.abs(loc.getBlockX() - this.loc.getBlockX()) > blockDiff) return false;
        if (Math.abs(loc.getBlockZ() - this.loc.getBlockZ()) > blockDiff) return false;
        return true;
    }

    public ArrayList<Location> getBlockList() {
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

    public ArrayList<Location> getOutline() {
        int blockDiff = type.equals(TowerType.THREE_BY_THREE) ? 1 : 2;
        ArrayList<Location> locs = new ArrayList<>();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        for (int dx = -blockDiff; dx <= blockDiff; dx++) {
            for (int dz = -blockDiff; dz <= blockDiff; dz++) {
                if (dx == -blockDiff || dz == -blockDiff || dx == blockDiff || dz == blockDiff)
                locs.add(new Location(loc.getWorld(), x + dx, y, z + dz));
            }
        }
        return locs;
    }

    public Direction getOutDirection() {
        return outDirection;
    }

    public Location getCenter() {
        return loc;
    }
}
