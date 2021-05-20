package com.s206megame.towerdefense;

import com.s206megame.towerdefense.mobs.ChickenJockeyMob;
import com.s206megame.towerdefense.mobs.WaveMobList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

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

    public boolean canAfford(int money) {
        return this.money >= money;
    }

    public void Start()
    {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -23.5, 6, -27.5));
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.ADVENTURE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
        }
        // wait 10 secs
        WaveMobList waveMobList = new WaveMobList();
        final WaveBar[] bar = {new WaveBar(1)};
        Main m;
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                int timer=1, wave=1;
                if (timer%120 == 0) {
                    wave++;
                    bar[0] = new WaveBar(wave);
                    bar[0].updateBar(1);
                }
                if (timer%120 == 1) waveMobList.getWave(wave).spawnWave();
                bar[0].updateBar((120-timer%120)/120);
                timer++;
            }

        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);



    }

    public void MainLoop(Main m) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (TowerSlot slot : Main.map.getTowerSlots()) {
                    if (slot.getTower() != null) {
                        slot.getTower().update();
                    }
                }
            }
        }.runTaskTimer(m,0L,1L);
    }

}
