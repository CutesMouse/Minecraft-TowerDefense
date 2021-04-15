package com.s206megame.towerdefense.map;

import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;

public class DefaultMap implements Map {
    private static ArrayList<TowerSlot> towerSlots;
    private static ArrayList<Mob> moblist;
    private static World WORLD;

    public DefaultMap() {
        moblist = new ArrayList<>();
        WORLD = Bukkit.getWorlds().get(0);
        // init towerslots
        initTowers(WORLD);


    }

    @Override
    public ArrayList<TowerSlot> getTowerSlots() {
        return towerSlots;
    }

    @Override
    public TowerSlot identifyTower(Location loc) {
        return towerSlots.stream().filter(p -> p.isInside(loc)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<Mob> getMobList() {
        return moblist;
    }

    @Override
    public Location getMobSpawnLocation() {
        return new Location(WORLD,-46,5,-48.5);
    }

    public void spawnMob(Class<? extends Mob> mob) {
        try {
            Mob mobEntity = mob.newInstance();
            moblist.add(mobEntity);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void initTowers(World w) {
        towerSlots = new ArrayList<>();
        for (int i = -43; i <= -13; i += 3) {
            towerSlots.add(new TowerSlot(new Location(w, -52, 5, i), TowerType.THREE_BY_THREE));
        }
        towerSlots.add(new TowerSlot(new Location(w, -38, 5, -2), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -2), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -44, 5, -2), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -47, 5, -2), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -50, 5, -1), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -51, 5, 2), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 5), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 8), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 11), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 14), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 17), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -38, 5, -6), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -6), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -44, 5, -6), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -47, 5, -6), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -50, 5, -7), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -51, 5, -10), TowerType.THREE_BY_THREE));
        towerSlots.add(new TowerSlot(new Location(w, -33, 5, -4), TowerType.FIVE_BY_FIVE));
    }
}
