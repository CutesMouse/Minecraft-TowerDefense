package com.s206megame.towerdefense.map.basic;

import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.tower.basic.Tower;
import com.s206megame.towerdefense.utils.CheckPoint;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Map {
    ArrayList<CheckPoint> getCheckpoints();

    Location getMobSpawnLocation();

    Location getEndPoint();
    double getEndPointOffset();

    Location getSpawnPoint();

    ArrayList<TowerSlot> getTowerSlots();

    LinkedList<Location> getCastleBlocks();

    ArrayList<Location> getFinalCastleBlocks();

    TowerSlot identifyTower(Location loc);
    ArrayList<Mob> getMobList();
    ArrayList<Tower> getTowers();
    Mob spawnMob(Class<? extends Mob> mob);
    void spawnSpiltSlime(Location parentLocation, int afterSize, int amount);
    void tickEvent();
    void start();
}
