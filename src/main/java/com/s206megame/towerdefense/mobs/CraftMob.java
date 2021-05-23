package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.effect.MobEffect;
import com.s206megame.towerdefense.utils.HoveringText;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

import java.util.ArrayList;
import java.util.Random;

public abstract class CraftMob implements Mob {

    protected boolean alive;
    protected int strengthen_offset = 1;
    protected double health;
    private int nameupdateDelay = 0;
    private boolean onFire = false;
    protected double slowness;
    private double yaw;
    private ArrayList<MobEffect> me = new ArrayList<>();
    protected double award = -1;

    public CraftMob() {
        this.health = getMaxHealth();
        this.slowness = 1.0;
        alive = true;
        this.award = getAward();
    }

    public static Mob SlimeSpilt(int slime) {
        switch (slime) {
            case 4:
                return new SlimeMob();
            case 2:
                return new SmallSlimeMob();
            case 1:
                return new MiniSlimeMob();
        }
        return null;
    }

    @Override
    public void moveMob(double distance) {
        double pi = (yaw + 90) * Math.PI / 180.0;
        double dx = Math.cos(pi) * distance * slowness;
        double dz = Math.sin(pi) * distance * slowness;
        Location c = getEntity().getLocation();
        double newX = c.getX() + dx;
        double newZ = c.getZ() + dz;
        double newY = c.getWorld().getHighestBlockAt((int) newX, (int) newZ).getLocation().getBlockY() + 1 + getYoffset();
        Location tpto = new Location(c.getWorld(), newX, newY, newZ, (float) yaw, 0);
        if (getEntity().getPassengers().size() != 0) {
            Entity pas = getEntity().getPassengers().get(0);
            pas.teleport(tpto);
            getEntity().teleport(tpto);
            getEntity().addPassenger(pas);
            return;
        }
        getEntity().teleport(tpto);
    }

    @Override
    public void onEntityMove() {
        if (getEntity().isDead() || !alive) {
            Main.map.getMobList().remove(this);
            return;
        }
        Main.map.getCheckpoints().stream().filter(p -> p.isPassBy(getEntity().getLocation(), getBlockPerTick() * 1.5 + 0.5)).findFirst().ifPresent(cp -> setFacingDegree(cp.getYaw()));
        //cps.add(new CheckPoint());
        if (getEntity().getLocation().distance(new Location(getEntity().getWorld(),-14,6,-47)) < 4) {
            TowerDefense.getInstance().removeHealth();
            kill();
        }
        moveMob(getBlockPerTick());
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void updateDisplayName() {
        nameupdateDelay++;
        if (nameupdateDelay < 20) {
            return;
        }
        Entity entity = getEntity();
        if (this.getClass().getSimpleName().equals("ChickenJockeyMob")) {
            entity = ((ChickenJockeyMob) this).getZombie();
        }
        entity.setCustomNameVisible(true);
        double health = getHealth();
        double max = getMaxHealth();
        double rate = health / max;
        rate *= 25;
        int ri = (int) rate;
        ri = 25 - ri;
        StringBuilder sb = new StringBuilder();
        sb.append("§f[§7");
        for (int i = 0; i <= 25; i++) {
            if (i == ri) {
                sb.append(rate>12.5? "§a" : (rate>5? "§e" : "§4"));
            }
            if (i == 25) {
                break;
            }
            sb.append("|");
        }
        sb.append("§f]");
        entity.setCustomName(sb.toString());
        nameupdateDelay = 0;
    }

    @Override
    public void kill() {
        alive = false;
        if (!(getEntity() instanceof LivingEntity)) {
            getEntity().remove();
            return;
        }
        ((LivingEntity) getEntity()).setHealth(0);
        Random r = new Random();
        new HoveringText("+ " + (Math.round(getAward()*10)/10D),getEntity().getLocation()
                .add(r.nextDouble()* 2 - 1,r.nextDouble(),r.nextDouble() * 2 - 1),20);
        TowerDefense.getInstance().addMoney(getAward());
    }

    @Override
    public void setFacingDegree(double yaw) {
        this.yaw = yaw;
    }

    @Override
    public void effectUpdate() {
        for (MobEffect e : getEffects()) {
            e.tickEvent(this);
        }
        getEffects().removeIf(p -> p.getDuration() <= 0);
    }

    @Override
    public ArrayList<MobEffect> getEffects() {
        return me;
    }

    @Override
    public void addEffect(MobEffect ef) {
        // 成功移除 -> 不加
        // 不成功移除 -> 原本有
        //          -> 原本沒有
        me.add(ef);
        if (!me.removeIf(ef::canOverwrite)) {
            boolean app = true;
            for (MobEffect m : me) {
                if (m.getType().equals(ef.getType())) app = false;
            }
            if (app) me.add(ef);
        }
    }

    @Override
    public boolean isOnFire() {
        return onFire;
    }

    @Override
    public void setOnFire(boolean t) {
        onFire = t;
        if (t) {
            getEntity().setFireTicks(Integer.MAX_VALUE);
        } else {
            getEntity().setFireTicks(0);
        }
    }

    @Override
    public void damage(double point) {
        if (!alive) return;
        if (getEntity() instanceof LivingEntity) {
            ((LivingEntity) getEntity()).damage(0);
        }
        health -= point;
        if (health <= 0) kill();
    }

    @Override
    public double getAward() {
        if (award >= 0) return award;
        return getMaxHealth() * getBlockPerTick() * 0.5 / strengthen_offset;
    }

    @Override
    public double getYoffset() {
        return 0;
    }

    @Override
    public void setSlowness(double ratio) {
        this.slowness = ratio;
    }

    @Override
    public void strengthen(int l) {
        strengthen_offset = (int)(Math.pow(2,l) * strengthen_offset);
        health = getMaxHealth();
    }
}
