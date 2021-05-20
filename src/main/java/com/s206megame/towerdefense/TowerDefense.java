package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerSlot;
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
