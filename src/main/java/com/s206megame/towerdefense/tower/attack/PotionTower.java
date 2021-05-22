package com.s206megame.towerdefense.tower.attack;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.effect.PoisonousEffect;
import com.s206megame.towerdefense.effect.SlownessEffect;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.Tower;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PotionTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.POTION;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 80;
            case 3:
                return 60;
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
                return 300;
            case 2:
                return 660;
            case 3:
                return 1620;
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 藥水塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f巫婆調製的§2劇毒藥水§f會要了你的命！","§f給予敵人§c持續數秒的傷害",
                "§f並緩速敵人!");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),0,7,0);
    }

    @Override
    protected Particle getParticle() {
        return Particle.SPELL;
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }

    @Override
    public void attackMob(Mob target) {
        lastAttack = System.currentTimeMillis();
        List<Mob> attackList = Main.map.getMobList().stream().filter(p -> p.getEntity().getLocation().distance(target.getEntity().getLocation()) < 5)
                .collect(Collectors.toList());
        for (Mob mob : attackList) {
            mob.addEffect(new PoisonousEffect(getDamage(),level));
            mob.addEffect(new SlownessEffect(getLevel(),(int) getHitDelay()));
            getWorld().spawnParticle(Particle.SPELL,mob.getEntity().getLocation(),1);
        }
        playParticle(target);
    }
}
