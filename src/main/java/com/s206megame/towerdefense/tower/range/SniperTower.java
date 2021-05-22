package com.s206megame.towerdefense.tower.range;

import com.s206megame.towerdefense.api.TowerType;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class SniperTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.OBSERVER;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 150;
            case 3:
                return 200;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 90;
            case 3:
                return 80;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 55;
            case 3:
                return 60;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 800;
            case 2:
                return 1500;
            case 3:
                return 2500;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 狙擊手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f無情的§c狙擊手§f隨時都將奪去戰場上敵人的性命！", "§f給予敵人§c致命傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,10,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.SMOKE_LARGE;
    }

    @Override
    public TowerType getType() {
        return TowerType.FIVE_BY_FIVE;
    }
}
