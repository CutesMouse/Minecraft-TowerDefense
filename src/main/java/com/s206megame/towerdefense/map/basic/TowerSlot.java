package com.s206megame.towerdefense.map.basic;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.build.Direction;
import com.s206megame.towerdefense.tower.basic.Tower;
import com.s206megame.towerdefense.tower.basic.TowerType;
import org.bukkit.Location;

import java.util.ArrayList;

public class TowerSlot {
    private Location loc;
    private TowerType type;
    private Direction outDirection;
    private Tower tower;

    public TowerSlot(Location loc, TowerType type, Direction outDirection) {
        this.loc = loc;
        this.type = type;
        this.outDirection = outDirection;
    }

    public void link(Tower tower) {
        this.tower = tower;
    }

    public void buildTower(Tower tower) {
        tower.build(this);
        Main.map.getTowers().add(tower);
        link(tower);
    }

    public void removeTower() {
        if (tower == null) return;
        tower.remove();
        Main.map.getTowers().remove(tower);
        tower = null;
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

    public Tower getTower() {
        return tower;
    }

    public TowerType getType() {
        return type;
    }
}
