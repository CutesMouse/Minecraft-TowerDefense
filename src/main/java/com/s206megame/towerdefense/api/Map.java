package com.s206megame.towerdefense.api;

import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.tower.Tower;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Map {
    ArrayList<TowerSlot> getTowerSlots();
    TowerSlot identifyTower(Location loc);
    ArrayList<Mob> getMobList();
    ArrayList<CheckPoint> getCheckpoints();
    Location getMobSpawnLocation();
    ArrayList<Tower> getTowers();
    LinkedList<Location> getCastleBlocks();
    ArrayList<Location> getFinalCastleBlocks();
}
