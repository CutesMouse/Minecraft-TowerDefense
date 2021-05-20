package com.s206megame.towerdefense.api;

import com.s206megame.towerdefense.ListenerHandler;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.player.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ScoreboardManager {
    public static void init(Main plugin) {
        PLAYER_TABLE = new HashMap<>();
        final Main f_plugin = plugin;
        ListenerHandler.registerLoginEvent(e -> {
            new BukkitRunnable() {
                @Override
                public void run() {
                    registerPlayer(e.getPlayer());
                }
            }.runTaskLater(f_plugin,1L);
            // delay to wait until player joins
        });
        for (Player p : Bukkit.getOnlinePlayers()) {
            registerPlayer(p);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                update();
            }
        }.runTaskTimer(plugin,0L,20L);
    }
    private static HashMap<String,PlayerScoreboard> PLAYER_TABLE;
    public static void registerPlayer(Player p) {
        Scoreboard ns = Bukkit.getScoreboardManager().getNewScoreboard();
        p.setScoreboard(ns);
        PlayerScoreboard ps = new PlayerScoreboard(ns, p);
        Objective obj = ns.registerNewObjective("list","dummy","§6Tower Defense");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        ObjectiveData od = new ObjectiveData(obj, p);

        od.addScoreData(new ScoreData(0).setUpd(player -> "Player Health: " + Math.round(player.getHealth()) + "\u2764"));
        od.addScoreData(new ScoreData(1).setUpd(player -> "§fPurse: §6" + MathTool.round(TowerDefense.getInstance().getMoney(),2)));
        od.addScoreData(new ScoreData(2).setUpd(player -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        ps.setObjectiveData(od);
        PLAYER_TABLE.put(p.getName(), ps);
    }
    public static void update() {
        PLAYER_TABLE.keySet().removeIf(p -> Bukkit.getPlayer(p) == null);
        for (PlayerScoreboard ps : PLAYER_TABLE.values()) {
            ps.update();
        }
    }
}
