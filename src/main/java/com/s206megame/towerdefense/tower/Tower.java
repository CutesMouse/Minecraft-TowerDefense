package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    public abstract Material getDisplayItem();
    public abstract double getDamage();
    public abstract double getHitDelay();
    public abstract double getRange();
    public abstract int getPrice();
    public abstract int getLevel();
    public abstract String getTitle();
    public abstract List<String> getDescription();
    public abstract void build(Location loc);

    public String getDescriptionTitle() {
        return "§f"+getTitle();
    }
    public ArrayList<String> getDescriptionLore() {
        ArrayList<String> re = new ArrayList<>();
        re.addAll(getDescription());
        re.add("射程： " + getRange());
        re.add("單次攻擊力： " +getDamage());
        re.add("攻擊頻率： " + getHitDelay());
        return re;
    }
}
