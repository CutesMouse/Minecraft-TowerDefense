package com.s206megame.towerdefense.tower.range;

import com.s206megame.towerdefense.tower.SolidBlockElement;
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
    protected void initStructure() {
        structure.register(new SolidBlockElement(-1,1,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(-1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(-1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,3,-1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(-1,3,0,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(-1,3,1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(-1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(-1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(-1,5,-1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(-1,5,0,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(-1,5,1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(-1,6,0,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,1,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,2,-1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,2,1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,3,-1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(0,3,1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(0,4,-1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,4,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,4,1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,5,-1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,5,1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,6,-1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(0,6,0,Material.OAK_PLANKS));
        structure.register(new SolidBlockElement(0,6,1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(1,1,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,3,-1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(1,3,0,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(1,3,1,Material.COBBLESTONE_SLAB));
        structure.register(new SolidBlockElement(1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(1,5,-1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(1,5,0,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(1,5,1,Material.OAK_STAIRS));
        structure.register(new SolidBlockElement(1,6,0,Material.OAK_STAIRS));

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
