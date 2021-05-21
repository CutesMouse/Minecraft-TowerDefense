package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.utils.Wave;
import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
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
        MainLoop(Main.getPlugin(Main.class));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -23.5, 6, -27.5));
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.CREATIVE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
        }
        Bukkit.getWorlds().get(0).setDifficulty(Difficulty.HARD);
        WaveBar.init("◤召喚中◢ 第 1 波 已召喚 0/49", BarColor.RED, BarStyle.SEGMENTED_10);
        WaveBar.setVisible(true);
    }
    private Wave currentWave;

    public void MainLoop(Main m) {
        new BukkitRunnable() {
            int waveCheckDelay = 0;
            @Override
            public void run() {
                for (Tower tower : Main.map.getTowers()) {
                    if (tower.getSlot() != null) {
                        tower.update();
                    }
                }
                waveCheckDelay++;
                if (waveCheckDelay % 20 == 0) {
                    waveCheckDelay = 0;
                    // next wave when:
                    // 1. all the mob has died
                    // 2. timer reached 120 seconds for each wave
                    // 3. first wave spawning
                    // This is checked every second.
                    if (currentWave == null || currentWave.hasEnded()) {
                        currentWave = WaveManager.getWaveData(currentWave == null ? 1 : (currentWave.getWave() + 1));
                        currentWave.spawnWave(); // Spawn the new wave
                    }
                    updateWaveBar();
                }
            }
        }.runTaskTimer(m, 0L, 1L);
    }
    private void updateWaveBar() {
        if (currentWave == null) return;
        if (!currentWave.isThread_end()) {
            // "◤召喚中◢ 第 1 波 已召喚 0/49";
            String title = "§b◤§c召喚中§b◢ §b第 §e%d §b波 已召喚 §e%d§b/§e%d";
            WaveBar.setTitle(String.format(title,currentWave.getWave(),currentWave.getProcess(),currentWave.getMaxMob()));
            WaveBar.setMaximum(currentWave.getMaxMob());
            WaveBar.setValue(currentWave.getProcess());
        } else {
            String title = "§b◤§a召喚完畢§b◢ §b第 §e%d §b波 剩餘 §e%d§b:§e%d §b怪物數量 §e%d§b/§e%d";
            int left = ((int) currentWave.getTimeLeft()) / 1000;
            int lm = left / 60;
            int ls = left % 60;
            WaveBar.setTitle(String.format(title,
                    currentWave.getWave(),lm,ls,
                    currentWave.getProcess(),currentWave.getMaxMob()));
            WaveBar.setMaximum(120);
            WaveBar.setValue(left);
        }
    }
}
