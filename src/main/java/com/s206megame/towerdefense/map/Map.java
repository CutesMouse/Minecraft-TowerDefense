package com.s206megame.towerdefense.map;

import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.utils.CheckPoint;
import com.s206megame.towerdefense.utils.TowerSlot;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Map {
    void tickEvent();
    ArrayList<TowerSlot> getTowerSlots();
    TowerSlot identifyTower(Location loc);
    ArrayList<Mob> getMobList();
    ArrayList<CheckPoint> getCheckpoints();
    Location getMobSpawnLocation();
    ArrayList<Tower> getTowers();
    LinkedList<Location> getCastleBlocks();
    ArrayList<Location> getFinalCastleBlocks();
    Mob spawnMob(Class<? extends Mob> mob);
    void spawnSpiltSlime(Location parentLocation, int afterSize, int amount);
    Location getEndPoint();
    double getEndPointOffset();
    Location getSpawnPoint();
    void start();
}
