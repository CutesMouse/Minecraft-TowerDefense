package com.s206megame.towerdefense.appearance;

import com.cutesmouse.mgui.Main;
import com.s206megame.towerdefense.ListenerHandler;
import com.s206megame.towerdefense.utils.Wave;
import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class WaveBar {
    private static BossBar bar;
    public static void init(String title, BarColor color, BarStyle style, BarFlag... flags) {
        bar = Bukkit.createBossBar(title,color, style,flags);
        for (Player p : Bukkit.getOnlinePlayers()) {
            bar.addPlayer(p);
        }
        ListenerHandler.registerLoginEvent(e -> {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!bar.getPlayers().contains(e.getPlayer())) bar.addPlayer(e.getPlayer());
                }
            }.runTaskLater(Main.getPlugin(Main.class),1L);
        });
    }
    private static int max = 100;
    private static int value = 100;
    public static void setMaximum(int value) {
        if (bar == null) return;
        max = value;
        setValue(WaveBar.value);
    }
    public static void setValue(int value) {
        if (bar == null) return;
        value = Math.min(value,max);
        WaveBar.value = value;
        bar.setProgress(value / (double) max);
    }
    public static void setVisible(boolean b) {
        if (bar == null) return;
        bar.setVisible(b);
    }
    public static void setTitle(String b) {
        if (bar == null) return;
        bar.setTitle(b);
    }
    public static void destroy() {
        if (bar == null) return;
        bar.removeAll();
    }
    public static void setColor(BarColor color) {
        bar.setColor(color);
    }
}

