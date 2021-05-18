package com.s206megame.towerdefense;

import com.google.common.base.Stopwatch;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.mobs.ChickenJockeyMob;
import com.s206megame.towerdefense.mobs.WaveMobList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Set;

public class TowerDefense {
    public static TowerDefense getInstance() {
        return new TowerDefense();
    }
    private int money;
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }

    public void Start()
    {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -23.5, 6, -27.5));
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.ADVENTURE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.closeInventory();
        }
        WaveMobList waveMobList = new WaveMobList();
        for (int wave = 1 ; wave <= 3; wave++)
        {
            WaveBar bar = new WaveBar(wave);
            // half time skip wave
            // skip wave when no mob
            waveMobList.getWave(wave).spawnWave();
            for (int sec = 120; sec>=120; sec--)
            {
                bar.updateBar((double) sec);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
