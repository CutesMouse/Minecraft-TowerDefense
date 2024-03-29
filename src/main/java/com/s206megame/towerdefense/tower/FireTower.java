package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.Tower;
import com.s206megame.towerdefense.tower.basic.TowerType;
import com.s206megame.towerdefense.effect.FireEffect;
import com.s206megame.towerdefense.effect.MobEffect;
import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.tower.basic.AbilityTower;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FireTower extends Tower implements AbilityTower {

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
                return 55;
            case 2:
                return 105;
            case 3:
                return 180;
        }
        return 0;
    }

    public double getFireDamage() {
        return getInitialDamage()*0.2;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 60;
            case 2:
                return 34;
            case 3:
                return 25;
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
                return 280;
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
        return Arrays.asList("§f燃燒吧，§c火鳥！", "§f使敵人得到§c火焰球的初始傷害","§c與持續數秒的燃燒傷害(初始傷害20%)");
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
        target.addEffect(new FireEffect(
                getInitialDamage(),
                getFireDamage(),
                getLevel()));
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }

    @Override
    public ArrayList<MobEffect> getAbilities() {
        return new ArrayList<>(Collections.singletonList(new FireEffect(getInitialDamage(), getFireDamage(), getLevel())));
    }
}
