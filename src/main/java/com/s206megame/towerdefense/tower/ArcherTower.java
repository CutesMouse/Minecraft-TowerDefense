package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.TowerType;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.basic.Tower;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class ArcherTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.BOW;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 15;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 18;
            case 2:
                return 13;
            case 3:
                return 10;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 15;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 600;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 弓箭手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f冷血的§c弓箭手§f躲在堅固的堡壘中，","§f準確§c射殺§f迎面而來的§c敵人！", "§f無特殊效果");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0.5,6,0.5);
    }

    @Override
    protected Particle getParticle() {
        return Particle.CRIT;
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }


}
