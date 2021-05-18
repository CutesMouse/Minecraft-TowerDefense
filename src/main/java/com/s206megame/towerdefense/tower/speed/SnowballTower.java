package com.s206megame.towerdefense.tower.speed;

import com.s206megame.towerdefense.effect.SlownessEffect;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public class SnowballTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.SNOWBALL;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 5;
            case 3:
                return 7;
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
                return 3;
            case 2:
                return 5;
            case 3:
                return 7;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 20;
            case 2:
                return 80;
            case 3:
                return 250;
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
        return new Location(getWorld(),-11,6,34);
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
}
