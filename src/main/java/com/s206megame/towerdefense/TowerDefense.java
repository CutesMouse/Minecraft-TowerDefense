package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.items.Items;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.utils.Wave;
import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.*;
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

    private boolean end;

    private int health = 20;

    public int getHealth() {
        return health;
    }

    public void removeHealth() {
        if (health <= 0) return;
        health --;
    }

    public void checkGameStat() {
        if (health <= 0) {
            announce("遊戲結束~");
        }
    }

    private int spawnDelay;

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
        money = 1000;
        MainLoop(Main.getPlugin(Main.class));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -23.5, 6, -27.5));
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.CREATIVE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
            p.getInventory().addItem(Items.BUILD_TOOL());
        }
        World world = Bukkit.getWorlds().get(0);
        world.setDifficulty(Difficulty.HARD);
        world.setGameRule(GameRule.DO_TILE_DROPS,false);
        WaveBar.init("Loading...", BarColor.RED, BarStyle.SEGMENTED_10);
        WaveBar.setVisible(true);
    }

    public void End() {

    }

    private Wave currentWave;

    public void MainLoop(Main m) {
        new BukkitRunnable() {
            boolean cleared = false;
            int money = 20;
            int waveCheckDelay = 0;
            int mobSpawnDelay = 400;
            @Override
            public void run() {
                if (end) {
                    this.cancel();
                    return;
                }
                money --;
                if (money == 0) {
                    TowerDefense.getInstance().money += 5;
                    money = 20;
                }
                for (Tower tower : Main.map.getTowers()) {
                    if (tower.getSlot() != null) {
                        tower.update();
                    }
                }
                if (mobSpawnDelay >= 0) {
                    if (mobSpawnDelay == 400) {
                        announce("首波怪物即將於§c20§e秒後生成!");
                    }
                    if (mobSpawnDelay <= 200 && mobSpawnDelay % 20 == 0) {
                        announce(String.format("首波怪物即將於§c%d§e秒後生成!",mobSpawnDelay / 20));
                    }
                    mobSpawnDelay--;
                    return;
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
                        if (cleared && currentWave != null &&
                                currentWave.getEndReason().equals(Wave.EndReason.MOB_CLEARED)) {
                            announce("太棒了! 由於你在時間內清除所有怪物，系統將跳過等待時間，於10秒後召喚下一波怪物!");
                            spawnDelay = 10;
                            WaveBar.setTitle("§e怪物準備中..");
                            cleared = false;
                            return;
                        }
                        if (spawnDelay > 0) {
                            if (spawnDelay <= 5) announce(String.format("下一波怪物即將於§c%d§e秒後生成!",spawnDelay));
                            spawnDelay--;
                            return;
                        }
                        currentWave = WaveManager.getWaveData(currentWave == null ? 1 : (currentWave.getWave() + 1));
                        currentWave.spawnWave(); // Spawn the new wave
                        cleared = true;
                        announce("============",false);
                        announce("守住你的村莊!!",false);
                        announce("第 " + currentWave.getWave() + " 波怪物開始攻擊!!",false);
                        announce("此波怪物共有 " + currentWave.getMaxMob()+" 隻",false);
                        announce("祝你好運!",false);
                        announce("============",false);
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT,1,1);
                        }
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
                    currentWave.getMobLeft(),currentWave.getMaxMob()));
            WaveBar.setMaximum(120);
            WaveBar.setValue(left);
        }
    }
    private void announce(String text) {
        announce(text,true);
    }
    private void announce(String text, boolean sound) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("§a[TowerDefense] §e" + text);
            if (sound) p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT,1,1);
        }
    }
}
