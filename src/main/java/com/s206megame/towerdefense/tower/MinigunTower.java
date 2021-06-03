package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.TowerType;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.basic.Tower;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class MinigunTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.DISPENSER;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 6;
            case 3:
                return 9;
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
                return 670;
            case 2:
                return 1320;
            case 3:
                return 4000;
        }
        return 0;
    }


    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 機關槍塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§c機關槍§f將會掃射來自四面八方的敵人，","§f再強大的怪物軍隊都將灰飛煙滅！", "§a快速發射§f大量的§c小子彈§f造成驚人的傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,7,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.FIREWORKS_SPARK;
    }

    @Override
    public int getMaxTargetAmount() {
        return 5;
    }

    @Override
    public TowerType getType() {
        return TowerType.FIVE_BY_FIVE;
    }
}
