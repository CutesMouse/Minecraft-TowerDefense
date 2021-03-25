package com.s206megame.towerdefense.api;

import org.bukkit.Location;

import java.util.ArrayList;

public interface Map {
    ArrayList<TowerSlot> getTowerSlots();
    TowerSlot identifyTower(Location loc);
}
