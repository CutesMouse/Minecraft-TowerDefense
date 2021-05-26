package com.s206megame.towerdefense;

import com.s206megame.towerdefense.utils.ScoreboardManager;
import com.s206megame.towerdefense.appearance.PlaceParticle;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.items.Items;
import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.utils.Wave;
import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class TowerDefense {
    private static TowerDefense INST;
    public static TowerDefense getInstance() {
        if (INST == null) INST = new TowerDefense();
        return INST;
    }

    private boolean end;

    private int health = 20;

    private long start_time;
    private long end_time;

    public long getTime() {
        if (start_time == 0) return -1;
        if (end_time == 0) return System.currentTimeMillis() - start_time;
        return end_time - start_time;
    }

    public int getHealth() {
        return health;
    }

    public Wave getCurrentWave() {
        return currentWave;
    }

    private LinkedList<Location> missing_blocks = new LinkedList<>();

    public void removeHealth() {
        health --;
        if (health <= 0) {
            End();
            return;
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CURE,0.5F,1);
            String color = (health > 10 ? "§a" : "§c");
            p.sendMessage("\u00a7c\u00a7lOh NO! \u00a7e怪物偷走了你的寶藏! 你剩下 "+color+health+"\u2764");
        }
        LinkedList<Location> cast = Main.map.getCastleBlocks();
        if (cast.size() == 0) return;
        Location loc = cast.poll();
        missing_blocks.addFirst(loc);
        loc.getBlock().breakNaturally();
    }

    public void addHealth() {
        if (health == 20) return;
        int ori = health;
        health = Math.min(20,health + 5);
        int delta = health - ori;
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE,0.5F,1);
            p.sendMessage("\u00a7a\u00a7lPOG! \u00a7e凋零怪為你帶來了財富! 你獲得了 §a"+delta+"\u2764");
        }
        LinkedList<Location> cast = Main.map.getCastleBlocks();
        Random r = new Random();
        for (int i = 0; i < delta; i++) {
            if (missing_blocks.size() == 0) break;
            Location poll = missing_blocks.poll();
            cast.addFirst(poll);
            poll.getBlock().setType(getRandomTreasure(r));
        }

    }

    public boolean hasStarted() {
        return start_time != 0;
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

    private Material getRandomTreasure(Random r) {
        ArrayList<Material> able = new ArrayList<>(Arrays.asList(Material.GOLD_BLOCK,Material.DIAMOND_BLOCK,Material.EMERALD_BLOCK));
        return able.get(r.nextInt(able.size()));
    }

    public void Start() {
        Main plugin = Main.getPlugin(Main.class);
        money = 3500;
        Main.map.start();
        start_time = System.currentTimeMillis();
        PlaceParticle.init(plugin);
        ScoreboardManager.init(plugin);
        Random r= new Random();
        ListenerHandler.registerLoginEvent(p -> p.getPlayer().setAllowFlight(true));
        for (Location castle : Main.map.getCastleBlocks()) {
            castle.getBlock().setType(getRandomTreasure(r));
        }
        for (Location loc : Main.map.getFinalCastleBlocks()) {
            loc.getBlock().setType(Material.REDSTONE_BLOCK);
        }
        MainLoop(Main.getPlugin(Main.class));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(Main.map.getSpawnPoint());
            p.sendTitle("§f歡迎來到§aTOWER DEFENSE！", "§f遊戲將在不久後開始", 10, 100, 10);
            p.setGameMode(GameMode.ADVENTURE);
            p.setAllowFlight(true);
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
        if (end) return;
        end = true;
        end_time = System.currentTimeMillis();
        for (Location loc : Main.map.getFinalCastleBlocks()) {
            loc.getBlock().breakNaturally();
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), -12.5, 5, -193.5));
            p.sendTitle("§c遊戲結束!", "§c怪物們搶走了你的寶藏並抓住了你", 10, 100, 10);
            p.setGameMode(GameMode.CREATIVE);
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            p.setFoodLevel(20);
            p.getInventory().clear();
            p.playSound(p.getLocation(),Sound.ENTITY_WITHER_DEATH,1,1);
        }
        announce("■■■■■■■■■■■■■■■■■■■■■", false);
        announce("§c面對一波又一波的怪物，你最終不敵，敗在了怪物手裡。", false);
        announce("§c你與你的隊員面對著未知的命運。", false);
        announce("§f下次請再接再勵!", false);
        announce("■■■■■■■■■■■■■■■■■■■■■", false);
        for (Mob mob : Main.map.getMobList()) {
            mob.kill();
        }
        WaveBar.setTitle("§a你撐到了第 " + currentWave.getWave() + " 波!");
        WaveBar.setVisible(true);
        WaveBar.setMaximum(100);
        WaveBar.setValue(100);
        WaveBar.setColor(BarColor.GREEN);
        new BukkitRunnable() {
            private final Random r = new Random();
            private int times = 10;
            @Override
            public void run() {
                times--;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Location loc = p.getLocation().clone().add(r.nextInt(30) - 15, r.nextInt(15), r.nextInt(30) - 15);
                    Firework fw = p.getWorld().spawn(loc, Firework.class);
                    fw.setFireworkMeta(getRandomMeta(r,fw));
                }
                if (times == 0) this.cancel();
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,20L);
    }

    private FireworkMeta getRandomMeta(Random r, Firework fw) {
        FireworkMeta meta = fw.getFireworkMeta();
        meta.addEffect(FireworkEffect.builder().flicker(r.nextBoolean()).trail(r.nextBoolean())
        .with(FireworkEffect.Type.values()[r.nextInt(FireworkEffect.Type.values().length)])
        .withColor(Color.fromBGR(r.nextInt(256*256*256)))
        .build());
        return meta;
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
                            if (spawnDelay <= 5) announce(String.format("下一波怪物即將於 §c%d§e 秒後生成!",spawnDelay));
                            spawnDelay--;
                            return;
                        }
                        currentWave = WaveManager.getWaveData(currentWave == null ? 1 : (currentWave.getWave() + 1));
                        currentWave.spawnWave(); // Spawn the new wave
                        cleared = true;
                        announce(String.format("§e■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n \n" +
                                "\n                                §e§l第 %02d 波" +
                                "\n                        §c§l守住你的村莊" +
                                "\n                       §c§l怪物開始攻擊!!" +
                                "\n                     §7#此波怪物共有 %d 隻"+
                                "\n                                 §6祝你好運" +
                                "\n \n§e■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■",currentWave.getWave(),currentWave.getMaxMob()),false,false);
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
            String title = "§b◤§a召喚完畢§b◢ §b第 §e%d §b波 剩餘 §e%d§b:§e%02d §b怪物數量 §e%d§b/§e%d";
            int left = ((int) currentWave.getTimeLeft()) / 1000;
            int lm = left / 60;
            int ls = left % 60;
            WaveBar.setTitle(String.format(title,
                    currentWave.getWave(),lm,ls,
                    currentWave.getMobLeft(),currentWave.getMaxMob()));
            WaveBar.setMaximum(Wave.WAVE_CD_SECOND);
            WaveBar.setValue(left);
        }
    }
    private void announce(String text) {
        announce(text,true);
    }
    private void announce(String text, boolean sound) {
        announce(text, sound,true);
    }
    private void announce(String text, boolean sound,boolean prefix) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage((prefix ? "§a[TowerDefense] §e" : "") + text);
            if (sound) p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT,1,1);
        }
    }
}
