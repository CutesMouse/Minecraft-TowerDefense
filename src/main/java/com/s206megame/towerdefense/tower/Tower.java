package com.s206megame.towerdefense.tower;

import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    protected TowerCategory category;
    protected int level;
    protected long lastAttack;

    public TowerCategory getCategory() {
        return category;
    }

    public StaticGUIItem getGUIItem() {
        return new StaticGUIItem(getDisplayItem(), getDescriptionTitle(), getDescriptionLore(), 1);
    }
    protected TowerStructure structure;

    public Tower() {
        structure = new TowerStructure();
        level = 1;
    }

    protected TowerStructure getStructure() {
        return TowerStructureBank.getStructure(level,getClass());
    }

    public abstract Material getDisplayItem();

    public abstract double getDamage();

    public abstract double getHitDelay();

    public abstract double getRange();

    public abstract int getPrice();

    public int getLevel() {
        return level;
    }

    public abstract String getTitle();

    public abstract List<String> getDescription();

    public void build(Location loc, Direction direct) {
        structure.build(loc,direct);
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
        if (isInCooldown()) return;
        lastAttack = System.currentTimeMillis();
        target.damage(getDamage());
    }

    public void playParticle(Mob target) {
        double vx = target.getEntity().getLocation().getX() - getParticleStartPoint().getX();
        double vy = target.getEntity().getLocation().getY() - getParticleStartPoint().getY();
        double vz = target.getEntity().getLocation().getZ() - getParticleStartPoint().getZ();
        Vector vec = new Vector(vx,vy,vz);
        ParticleManager.playParticle(getParticleStartPoint(),vec,Math.sqrt(vx*vx+vy*vy+vz*vz),0.5,getParticle());
    }

}
