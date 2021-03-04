package com.s206megame.towerdefense.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public class ScoreboardManager {
    public static void init() {
        PLAYER_TABLE = new HashMap<>();
    }
    private static HashMap<String,PlayerScoreboard> PLAYER_TABLE;
    public static void registerPlayer(Player p) {
        Scoreboard ns = Bukkit.getScoreboardManager().getNewScoreboard();
        p.setScoreboard(ns);
        PLAYER_TABLE.put(p.getName(),new PlayerScoreboard(ns,p));
    }
    public static void update() {
        PLAYER_TABLE.keySet().removeIf(p -> Bukkit.getPlayer(p) == null);
    }
}
