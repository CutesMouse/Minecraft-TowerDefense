package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.basic.TowerType;
import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.appearance.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
import com.s206megame.towerdefense.tower.basic.Tower;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;

public class DariusTower extends Tower {

    @Override
    public Material getDisplayItem() {
        return Material.ANVIL;
    }

    @Override
    public double getDamage() {
        return 20000;
    }

    @Override
    public double getHitDelay() {
        return 200;
    }

    @Override
    public double getRange() {
        return 10;
    }

    @Override
    public int getPrice(int level) {
        return 5000;
    }

    @Override
    public String getTitle() {
        return "[Lv."+99999+"] 巨錘瑞斯";
    }


    @Override
    public List<String> getDescription() {
        return Arrays.asList("§c巨錘瑞斯，開剁！","§f給予敵人§c致命的最後一擊，保證擊殺");
    }

    @Override
    protected Location getParticleStartPoint() {
        return new Location(getWorld(),1,5.5,-1);
    }

    @Override
    protected Particle getParticle() {
        return Particle.BLOCK_CRACK;
    }

    @Override
    public void playParticle(Mob target) {
        double vx = target.getEntity().getLocation().getX() - getConvertedParticleStart().getX();
        double vy = target.getEntity().getLocation().getY() - getConvertedParticleStart().getY();
        double vz = target.getEntity().getLocation().getZ() - getConvertedParticleStart().getZ();
        Vector vec = new Vector(vx,vy,vz);
        ParticleManager.playParticle(getConvertedParticleStart(),vec,Math.sqrt(vx*vx+vy*vy+vz*vz),0.2,getParticle(),Material.REDSTONE_BLOCK.createBlockData());
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public TowerType getType() {
        return TowerType.THREE_BY_THREE;
    }
}
