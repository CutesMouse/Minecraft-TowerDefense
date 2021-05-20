package com.s206megame.towerdefense.tower;

import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    protected TowerCategory category;
    protected int level;
    protected long lastAttack;
    protected TowerSlot location;
    private Location converted;
    protected TowerAI ai;

    public TowerCategory getCategory() {
        return category;
    }

    public StaticGUIItem getGUIItem() {
        return new StaticGUIItem(getDisplayItem(), getDescriptionTitle(), getDescriptionLore(), 1);
    }

    public Tower() {
        level = 1;
        ai = new BaseTargetAI(this);
    }

    public Tower setLevel(int level) {
        this.level = level;
        return this;
    }

    public void update() {
        if (isInCooldown()) return;
        for (Mob mob : ai.getTarget(Main.map)) {
            attackMob(mob);
        }
    }

    protected TowerStructure getStructure() {
        return TowerStructureBank.getStructure(level,getClass());
    }

    public abstract Material getDisplayItem();

    public abstract double getDamage();

    public abstract double getHitDelay();

    public abstract double getRange();

    public abstract int getPrice(int level);

    public int getLevel() {
        return level;
    }

    public abstract String getTitle();

    public abstract List<String> getDescription();

    public void build(TowerSlot slot) {
        if (isPlaced()) slot.removeTower();
        TowerStructureBank.getStructure(getLevel(),this.getClass()).build(slot.getCenter(),slot.getOutDirection());
        this.location = slot;
    }

    public String getDescriptionTitle() {
        return "§f"+getTitle();
    }

    public ArrayList<String> getDescriptionLore() {
        ArrayList<String> re = new ArrayList<>();
        re.addAll(getDescription());
        re.add("射程： " + getRange());
        re.add("單次攻擊力： " +getDamage());
        re.add("攻擊頻率： " + getHitDelay());
        return re;
    }

    protected abstract Location getParticleStartPoint();

    protected abstract Particle getParticle();

    protected boolean isInCooldown() {
        return System.currentTimeMillis() - lastAttack < getHitDelay() * 50;
    }

    public void attackMob(Mob target) {
        lastAttack = System.currentTimeMillis();
        target.damage(getDamage());
        playParticle(target);
    }

    public void playParticle(Mob target) {
        Location cl = getConvertedParticleStart();
        Location ml = target.getEntity().getLocation();
        double vx = ml.getX() - cl.getX();
        double vy = ml.getY() - cl.getY();
        double vz = ml.getZ() - cl.getZ();
        Vector vec = new Vector(vx,vy,vz);
        ParticleManager.playParticle(getConvertedParticleStart(),vec.normalize(),Math.sqrt(vx*vx+vy*vy+vz*vz),0.5,getParticle());
    }

    protected World getWorld() {
        return getSlot().getCenter().getWorld();
    }

    public boolean isPlaced() {
        return location != null;
    }

    public void remove() {
        if (location == null) return;
        getStructure().remove(location.getCenter(),location.getOutDirection());
    }

    public Location getConvertedParticleStart() {
        if (converted != null) return converted;
        Location sp = getParticleStartPoint();
        Location center = location.getCenter();
        double vx = sp.getX();
        double vz = sp.getZ();
        double theta = location.getOutDirection().getRad() - Direction.NORTH.getRad();
        double dx = vx * Math.cos(theta) - vz * Math.sin(theta);
        double dz = vx * Math.sin(theta) + vz * Math.cos(theta);
        converted = new Location(center.getWorld(), center.getX() + dx, sp.getY() + center.getBlockY(), center.getZ() + dz);
        return converted;
    }

    public TowerSlot getSlot() {
        return location;
    }

    public int getMaxTargetAmount() {
        return 1;
    }

    public abstract TowerType getType();
}
