package com.s206megame.towerdefense.appearance;

import com.s206megame.towerdefense.ListenerHandler;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.utils.MathTool;
import com.s206megame.towerdefense.utils.ObjectiveData;
import com.s206megame.towerdefense.utils.PlayerScoreboard;
import com.s206megame.towerdefense.utils.ScoreData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

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
    private static HashMap<String, PlayerScoreboard> PLAYER_TABLE;
    public static void registerPlayer(Player p) {
        Scoreboard ns = Bukkit.getScoreboardManager().getNewScoreboard();
        p.setScoreboard(ns);
        PlayerScoreboard ps = new PlayerScoreboard(ns, p);
        Objective obj = ns.registerNewObjective("list","dummy","§6Tower Defense");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        ObjectiveData od = new ObjectiveData(obj, p);

        /*
        6
        經過時間 / 00:00    5
        寶藏剩餘 / 20       4
        金錢 / 0.0         3
        波數 / 2           2
        玩家 / 3           1
        0
         */
        final TowerDefense td = TowerDefense.getInstance();
        od.addScoreData(new ScoreData(6).setUpd(player -> "§f§e"));
        od.addScoreData(new ScoreData(5).setUpd(player -> {
            String time_string = null;
            long time = td.getTime();
            if (time == -1) time_string = "§e尚未開始";
            else {
                int minute = (int) (time / 1000) / 60;
                int sec = (int) (time / 1000) % 60;
                time_string = String.format("§6%2d:%02d",minute,sec);
            }
            return "§f經過時間 §7/ " + time_string;
        }));
        od.addScoreData(new ScoreData(4).setUpd(player -> {
            int h = td.getHealth();
            String color = h > 10 ? "§a" : "§c";
            return "§f主堡血量 §7/ "+color+h+"\u2764";
        }));
        od.addScoreData(new ScoreData(3).setUpd(player -> "§f金錢 §7/ §6" + MathTool.round(td.getMoney(),2)));
        od.addScoreData(new ScoreData(2).setUpd(player -> {
            String wave;
            if (td.getCurrentWave() == null) {
                wave = "-";
            } else {
                wave = "第 " + td.getCurrentWave().getWave() + " 波";
            }
            return "§f波數 §7/ §6" + wave;
        } ));
        od.addScoreData(new ScoreData(1).setUpd(player -> "§f玩家 §7/ §6" + Bukkit.getOnlinePlayers().size()));
        od.addScoreData(new ScoreData(0).setUpd(player -> "§6§e"));

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
