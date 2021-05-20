package com.s206megame.towerdefense;

import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.mobs.WaveMobList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


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
            p.setGameMode(GameMode.CREATIVE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
        }

        WaveMobList waveMobList = new WaveMobList();
        // WaveBar bar = new WaveBar(1):
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                int timer=1, wave=1;
                if (timer%120 == 0) {
                    wave++;
                    //bar = new WaveBar(wave);
                    //bar.updateBar(1);
                }
                if (timer%120 == 1) waveMobList.getWave(wave).spawnWave();
                // bar.updateBar(120-timer);
                timer++;
            }

        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);



    }

}
