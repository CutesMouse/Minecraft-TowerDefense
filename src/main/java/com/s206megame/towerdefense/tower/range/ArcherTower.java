package com.s206megame.towerdefense.tower.range;

import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class ArcherTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Range;

    @Override
    public Material getDisplayItem() {
        return Material.BOW;
    }

    @Override
    public double getDamage() {
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
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 8;
            case 3:
                return 5;
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
    public int getPrice() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 110;
            case 3:
                return 300;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 弓箭手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f冷血的弓箭手躲在堅固的堡壘中，§f準確§c射殺§f迎面而來的§c敵人！", "§f無特殊效果");
    }


}
