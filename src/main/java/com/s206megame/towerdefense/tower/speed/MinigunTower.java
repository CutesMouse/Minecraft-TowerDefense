package com.s206megame.towerdefense.tower.speed;

import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class MinigunTower extends Tower {


    private int level;
    TowerCategory category = TowerCategory.Speed;
    @Override
    public Material getDisplayItem() {
        return Material.DISPENSER;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 4;
            case 2:
                return 6;
            case 3:
                return 8;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 10;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1:
                return 70;
            case 2:
                return 210;
            case 3:
                return 800;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 機關槍塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f機關槍將會掃射來自四面八方的敵人，","§f再強大的怪物軍隊都將輝飛煙滅！", "快速發射大量的§c小子彈§f造成驚人的傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return null;
    }

    @Override
    protected Particle getParticle() {
        return null;
    }
}
