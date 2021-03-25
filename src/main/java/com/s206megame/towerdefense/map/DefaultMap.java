package com.s206megame.towerdefense.map;

import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.api.TowerType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;

public class DefaultMap implements Map {
    private static ArrayList<TowerSlot> towerSlots;
    public DefaultMap() {
        World w = Bukkit.getWorlds().get(0);
        // init towerslots
        initTowers(w);


    }
    @Override
    public ArrayList<TowerSlot> getTowerSlots() {
        return towerSlots;
    }

    @Override
    public TowerSlot identifyTower(Location loc) {
        return towerSlots.stream().filter(p -> p.isInside(loc)).findFirst().orElse(null);
    }

    private void initTowers(World w) {
        towerSlots = new ArrayList<>();
        for (int i = -43; i <= -13; i += 3) {
            towerSlots.add(new TowerSlot(new Location(w,-52,5,i), TowerType.THREE_BY_THREE));
        }
    }
}
