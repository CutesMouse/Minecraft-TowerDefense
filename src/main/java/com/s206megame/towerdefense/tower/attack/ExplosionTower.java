package com.s206megame.towerdefense.tower.attack;

import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class ExplosionTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Attack;

    @Override
    public Material getDisplayItem() {
        return Material.TNT;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 75;
            case 2:
                return 100;
            case 3:
                return 150;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 40;
            case 3:
                return 30;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1:
                return 240;
            case 2:
                return 450;
            case 3:
                return 1200;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 炸藥塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f用§c炸藥§f讓敵人粉身碎骨！","§f短時間內給予敵人§c大量傷害");
    }


}
