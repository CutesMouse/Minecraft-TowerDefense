package com.s206megame.towerdefense.tower.attack;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.TowerCategory;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExplosionTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.TNT;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 75;
            case 3:
                return 100;
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
                return 10;
            case 2:
                return 12;
            case 3:
                return 16;
        }
        return 0;
    }

    @Override
    public int getPrice(int level) {
        switch (level) {
            case 1:
                return 480;
            case 2:
                return 900;
            case 3:
                return 2400;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 炸藥塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f用§c炸藥§f讓敵人粉身碎骨！","§f短時間內給予敵人§c大量傷害");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,7,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.EXPLOSION_HUGE;
    }

    @Override
    public void attackMob(Mob target) {
        lastAttack = System.currentTimeMillis();
        List<Mob> attackList = Main.map.getMobList().stream().filter(p -> p.getEntity().getLocation().distance(target.getEntity().getLocation()) < 3)
                .collect(Collectors.toList());
        for (Mob mob : attackList) {
            mob.damage(getDamage());
            getWorld().spawnParticle(Particle.FLASH,mob.getEntity().getLocation(),1);
        }
        getWorld().spawnParticle(Particle.EXPLOSION_HUGE,target.getEntity().getLocation(),1);
    }

    @Override
    public TowerType getType() {
        return TowerType.FIVE_BY_FIVE;
    }
}
