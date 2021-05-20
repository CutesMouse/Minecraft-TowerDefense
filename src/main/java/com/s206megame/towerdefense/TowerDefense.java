package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.utils.Wave;
import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TowerDefense {
    private static TowerDefense INST;
    public static TowerDefense getInstance() {
        if (INST == null) INST = new TowerDefense();
        return INST;
    }

    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void removeMoney(double money) {
        this.money -= money;
    }

    public boolean canAfford(double money) {
        return this.money >= money;
    }

    public void Start() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -23.5, 6, -27.5));
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.CREATIVE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
        }
        new BukkitRunnable() {
            int waveVal=0, timer=-1;
            Wave currentWave;
            WaveBar currentBar;
            @Override
            public void run() {
                timer++;
                if (currentWave.hasEnded() || waveVal == 0 || timer%120 == 0) {
                    // next wave when:
                        // 1. all the mob has died
                        // 2. timer reached 120 seconds for each wave
                        // 3. first wave spawning
                        // This is checked every second.
                    currentBar = new WaveBar(++waveVal);
                    currentWave = WaveManager.getWaveData(waveVal);
                    currentWave.spawnWave(); // Spawn the new wave
                }
                currentBar.updateBar(120-timer);
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,20L);



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
        }.runTaskTimer(m, 0L, 1L);
    }
}
