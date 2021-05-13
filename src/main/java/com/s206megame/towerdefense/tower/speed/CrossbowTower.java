package com.s206megame.towerdefense.tower.speed;

import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class CrossbowTower extends Tower {

    private TowerCategory category = TowerCategory.Speed;
    @Override
    public Material getDisplayItem() {
        return Material.CROSSBOW;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 4;
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
                return 7;
            case 2:
                return 5;
            case 3:
                return 3;
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
                return 14;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1:
                return 60;
            case 2:
                return 170;
            case 3:
                return 470;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 十字弓手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§c十字弓§f射出的快速弓箭將讓敵人無從應對！", "§a快速§f射出能造成§c中等傷害的弓箭");
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
