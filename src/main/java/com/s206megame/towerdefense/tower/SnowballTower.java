package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.Tower;
import com.s206megame.towerdefense.tower.basic.TowerType;
import com.s206megame.towerdefense.effect.MobEffect;
import com.s206megame.towerdefense.effect.SlownessEffect;
import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.tower.basic.AbilityTower;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SnowballTower extends Tower implements AbilityTower {

    @Override
    public Material getDisplayItem() {
        return Material.SNOWBALL;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 1;
            case 2:
                return 2.5;
            case 3:
                return 3.5;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 2;
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
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 320;
            case 3:
                return 450;
        }
        return 0;
    }


    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 雪球塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f來自雪人的祝福，在戰場上開啟一場§a雪球大戰！", "§f使敵人得到§c減速效果數秒");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,6,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.SNOWBALL;
    }

    @Override
    public void attackMob(Mob target) {
        super.attackMob(target);
        target.addEffect(new SlownessEffect(level));
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }

    @Override
    public ArrayList<MobEffect> getAbilities() {
        return new ArrayList<>(Collections.singletonList(new SlownessEffect(level)));
    }
}
