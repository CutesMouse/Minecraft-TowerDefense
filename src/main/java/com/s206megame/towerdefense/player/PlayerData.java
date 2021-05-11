package com.s206megame.towerdefense.player;

import com.s206megame.towerdefense.api.TowerSlot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerData {
    private double balance;
    private int mob_killed;
    private final String name;
    private TowerSlot slot;
    public PlayerData(String name) {
        this.name = name;
        this.mob_killed = 0;
        balance = 0;
    }

    public void setSlot(TowerSlot slot) {
        this.slot = slot;
    }

    public TowerSlot getSlot() {
        return slot;
    }

    public boolean hasSlot() {
        return slot != null;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(name);
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean balanceLeftOver(double amount) {
        return balance >= amount;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double d) {
        this.balance = d;
    }
}
