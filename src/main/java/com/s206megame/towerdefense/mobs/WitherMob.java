package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.TowerDefense;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;

import java.util.Objects;

public class WitherMob extends CraftMob {

    private Wither wither;
    private static final double MAX_HEALTH = 5000.0;

    @Override
    public Entity getEntity() {
        return wither;
    }

    @Override
    public String getMobName() {
        return "Wither";
    }

    @Override
    public String getMobID() {
        return "wither";
    }

    @Override
    public void spawn(Location loc) {
        Wither entity = loc.getWorld().spawn(loc, Wither.class);
        this.wither = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.15 * strengthen_offset;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH * strengthen_offset;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void damage(double point) {
        super.damage(point);
        if (health < 0) {
            TowerDefense.getInstance().addHealth();
        }
        double ratio = getHealth() / getMaxHealth();
        if (ratio < 0 || ratio > 1) return;
        wither.setHealth(300.0 * ratio);
    }

    @Override
    public void kill() {
        super.kill();
    }
}
