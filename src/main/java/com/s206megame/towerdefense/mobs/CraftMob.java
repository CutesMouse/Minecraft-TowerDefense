package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.effect.MobEffect;
import org.bukkit.Location;

import java.util.ArrayList;

public abstract class CraftMob implements Mob {
    private static Map getMap() {
        return Main.map;
    }

    private int nameupdateDelay = 0;
    private boolean onFire = false;
    private double yaw;
    private ArrayList<MobEffect> me = new ArrayList<>();

    @Override
    public void moveMob(double distance) {
        double pi = (yaw + 90) * Math.PI / 180.0;
        double dx = Math.cos(pi) * distance;
        double dz = Math.sin(pi) * distance;
        Location c = getEntity().getLocation();
        double newX = c.getX() + dx;
        double newZ = c.getZ() + dz;
        double newY = c.getWorld().getHighestBlockAt((int) newX, (int) newZ).getLocation().getBlockY() + 1;
        getEntity().teleport(new Location(c.getWorld(), newX, newY, newZ, (float) yaw, 0));
    }

    @Override
    public void onEntityMove() {
        if (getEntity().isDead()) {
            Main.map.getMobList().remove(this);
            return;
        }
        Main.map.getCheckpoints().stream().filter(p -> p.isPassBy(getEntity().getLocation(), getTickPerBlock() * 1.5)).findFirst().ifPresent(cp -> setFacingDegree(cp.getYaw()));
        moveMob(getTickPerBlock());
    }

    @Override
    public void updateDisplayName() {
        nameupdateDelay++;
        if (nameupdateDelay < 20) {
            return;
        }
        getEntity().setCustomNameVisible(true);
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
                sb.append("§a");
            }
            if (i == 25) {
                break;
            }
            sb.append("|");
        }
        sb.append("§f]");
        getEntity().setCustomName(sb.toString());
        nameupdateDelay = 0;
    }

    @Override
    public void kill() {
        getEntity().remove();
    }

    @Override
    public void setFacingDegree(double yaw) {
        this.yaw = yaw;
    }

    @Override
    public void effectUpdate() {
        System.out.println("k: "+getEffects().size());
        for (MobEffect e : getEffects()) {
            System.out.println("Do update");
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
        System.out.println(me.size());
        System.out.println("Add");
        /*if (!me.removeIf(ef::canOverwrite)) {
            boolean app = true;
            for (MobEffect m : me) {
                if (m.getType().equals(ef.getType())) app = false;
            }
            if (app) me.add(ef);
        }*/
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
}
