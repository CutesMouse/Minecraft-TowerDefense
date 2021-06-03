package com.s206megame.towerdefense.tower.basic;

import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.build.Direction;
import com.s206megame.towerdefense.build.TowerStructure;
import com.s206megame.towerdefense.build.TowerStructureBank;
import com.s206megame.towerdefense.utils.MathTool;
import com.s206megame.towerdefense.map.basic.TowerSlot;
import com.s206megame.towerdefense.effect.MobEffect;
import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.appearance.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    public abstract int getPrice(int level);

    public abstract double getHitDelay();

    public abstract double getDamage();

    public abstract double getRange();

    protected abstract Particle getParticle();

    protected TowerStructure getStructure() {
        return TowerStructureBank.getStructure(level,getClass());
    }

    protected int level;
    protected long lastAttack;
    protected TowerSlot location;
    private Location converted;
    protected TowerAI ai;

    public StaticGUIItem getGUIItem() {
        StaticGUIItem item = new StaticGUIItem(getDisplayItem());
        item.setItemName(getDescriptionTitle());
        item.setItemLore(getDescriptionLore());
        return item;
    }

    public Tower() {
        level = 1;
        ai = new BaseTargetAI(this);
    }

    public void upgrade() {
        if (level +1 > getMaxLevel()) return;
        remove();
        TowerStructureBank.getStructure(level+1,this.getClass())
                .build(getSlot().getCenter(),getSlot().getOutDirection());
        level++;
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


    public abstract Material getDisplayItem();

    public int getPrice() {
        int level = this.level;
        int price = 0;
        while (level != 0) {
            price += getPrice(level);
            level--;
        }
        return price;
    }

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
        if (this instanceof AbilityTower) {
            for (MobEffect effect : ((AbilityTower) this).getAbilities()) {
                re.add("");
                re.addAll(effect.getDescription());
            }
        }
        re.add("");
        re.add("§a射程： §e半徑 " + getRange()+ " 格");
        re.add("§a單次攻擊力： §e每次 " +getDamage() + " 點傷害");
        re.add("§a攻擊頻率： §e每秒 " + MathTool.round(20D / getHitDelay(),2) + " 次");
        re.add("");
        re.add("§a費用: §e" + getPrice(level));
        re.add("");
        if (level != getMaxLevel()) re.add("§e點擊完成建造!");
        return re;
    }

    public ArrayList<String> getUpgradeDescriptionLore(Tower oldTower) {
        ArrayList<String> re = new ArrayList<>();
        re.addAll(getDescription());//➲
        if (this instanceof AbilityTower && oldTower instanceof AbilityTower) {
            int position = 0;
            for (MobEffect effect : ((AbilityTower) this).getAbilities()) {
                re.add("");
                re.addAll(effect.getUpgradeDescription(((AbilityTower) oldTower).getAbilities().get(position)));
                position++;
            }
        }
        re.add("");
        re.add("§a射程： §e半徑 §7" + oldTower.getRange() + " §e(➲"+getRange()+ ") 格");
        re.add("§a單次攻擊力： §e每次 §7" + oldTower.getDamage() + " §e(➲" + getDamage() + ") 點傷害");
        re.add("§a攻擊頻率： §e每秒 §7" + MathTool.round(20D / oldTower.getHitDelay(),2) + " §e(➲"+
                MathTool.round(20D / getHitDelay(),2) + ") 次");
        re.add("");
        re.add("§a費用: §e" + getPrice(level));
        return re;
    }

    protected double getDPS() {
        return (20D / getHitDelay()) * getDamage();
    }

    protected abstract Location getParticleStartPoint();

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
        ParticleManager.playParticle(getConvertedParticleStart(),vec.normalize(),Math.sqrt(vx*vx+vy*vy+vz*vz),1,getParticle());
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

    public int getMaxLevel() {
        return 3;
    }
}
