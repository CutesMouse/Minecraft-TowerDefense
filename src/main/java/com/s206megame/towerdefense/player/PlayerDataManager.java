package com.s206megame.towerdefense.player;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerDataManager {
    private static HashMap<String,PlayerData> PDS = new HashMap<>();
    // Map for each player, searched by name
    public static PlayerData getPlayerData(Player p) {
        return getPlayerData(p.getName());
    }
    public static PlayerData getPlayerData(String p) {
        if (PDS.containsKey(p)) return PDS.get(p);
        PlayerData newD = new PlayerData(p); // new assigned player
        PDS.put(p,newD);
        return newD;
    }
}
