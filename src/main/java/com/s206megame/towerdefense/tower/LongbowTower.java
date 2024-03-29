package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.TowerType;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.basic.Tower;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class LongbowTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.ARROW;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 60;
            case 2:
                return 120;
            case 3:
                return 190;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 80;
            case 2:
                return 70;
            case 3:
                return 50;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 40;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 185;
            case 2:
                return 250;
            case 3:
                return 500;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 長弓手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§c長弓手§f以其精準的預判能力，","§f遠程射殺敵人！", "§f給予敵人§c高傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,6,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.END_ROD;
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }
}
