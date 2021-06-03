package com.s206megame.towerdefense.player;

import com.s206megame.towerdefense.map.basic.TowerSlot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerData {
    private final String name;
    private TowerSlot slot;
    public PlayerData(String name) {
        this.name = name;
    }

    public void setSlot(TowerSlot slot) {
        this.slot = slot;
    }

    public TowerSlot getSlot() {
        return slot;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(name);
    }
}
