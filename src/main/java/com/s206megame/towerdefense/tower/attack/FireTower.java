package com.s206megame.towerdefense.tower.attack;

import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.effect.FireEffect;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class FireTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.FIRE_CHARGE;
    }

    @Override
    public double getDamage() {
        return getInitialDamage();
    } // unused

    public double getInitialDamage() {
        switch (level) {
            case 1:
                return 80;
            case 2:
                return 90;
            case 3:
                return 100;
        }
        return 0;
    }

    public double getFireDamage() {
        return getInitialDamage()*0.1;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 70;
            case 2:
                return 60;
            case 3:
                return 50;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
                return 12;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 320;
            case 2:
                return 640;
            case 3:
                return 1280;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 烈焰塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f燃燒吧，§c火鳥！", "§f使敵人得到§c火焰球的初始傷害與持續數秒的傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,5,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.LAVA;
    }

    @Override
    public void attackMob(Mob target) {
        super.attackMob(target);
        target.addEffect(new FireEffect(getInitialDamage(),getFireDamage(),getLevel()));
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }
}
