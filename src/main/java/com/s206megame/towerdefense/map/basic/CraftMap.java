package com.s206megame.towerdefense.map.basic;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.mobs.basic.CraftMob;
import com.s206megame.towerdefense.mobs.basic.Mob;
import com.s206megame.towerdefense.tower.basic.Tower;
import com.s206megame.towerdefense.utils.Wave;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public abstract class CraftMap implements Map {
    protected ArrayList<TowerSlot> towerSlots;
    protected ArrayList<Mob> moblist;
    protected ArrayList<Tower> towers;
    protected ArrayList<CheckPoint> cps;
    protected static World WORLD;
    protected LinkedList<Location> castleBlocks;
    protected ArrayList<Location> finalCastleBlocks;

    public CraftMap() {
        WORLD = Bukkit.getWorlds().get(0);
        moblist = new ArrayList<>();
        towers = new ArrayList<>();
        initTowers();
        initCheckpoints();
        castCheckpointAngles();
        initCastleBlocks();
        initFinalCastleBlocks();
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Main.map == null || !Main.map.equals(CraftMap.this)) {
                    this.cancel();
                    return;
                }
                tickEvent();
            }
        }.runTaskTimer(Main.getPlugin(Main.class),0L,1L);
    }

    // @定義: 每個TowerSlot的位置
    protected abstract void initTowers();

    // @定義: 每個終點寶藏方塊的位置
    protected abstract void initCastleBlocks();

    // @定義: 每個轉彎點的角度與位置
    protected abstract void initCheckpoints();

    // @定義: 最終紅石方塊的位置
    protected abstract void initFinalCastleBlocks();

    @Override
    public void tickEvent() {
        if (moblist.size() > 0) {
            ArrayList<Mob> copy = new ArrayList<>(moblist);
            for (Mob mob : copy) {
                if (mob == null) continue;
                mob.onEntityMove();
                mob.updateDisplayName();
                mob.effectUpdate();
            }
        }
    }

    @Override
    public ArrayList<Mob> getMobList() {
        return moblist;
    }

    @Override
    public ArrayList<CheckPoint> getCheckpoints() {
        return cps;
    }

    @Override
    public ArrayList<Tower> getTowers() {
        return towers;
    }

    @Override
    public ArrayList<TowerSlot> getTowerSlots() {
        return towerSlots;
    }

    @Override
    public ArrayList<Location> getFinalCastleBlocks() {
        return finalCastleBlocks;
    }

    @Override
    public TowerSlot identifyTower(Location loc) {
        return towerSlots.stream().filter(p -> p.isInside(loc)).findFirst().orElse(null);
    }

    @Override
    public LinkedList<Location> getCastleBlocks() {
        return castleBlocks;
    }

    @Override
    public Mob spawnMob(Class<? extends Mob> mob) {
        try {
            Mob mobEntity = mob.newInstance();
            mobEntity.spawn(getMobSpawnLocation());
            moblist.add(mobEntity);
            return mobEntity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void spawnSpiltSlime(Location parentLocation, int afterSize, int amount) {
        if (amount == 0) return;
        Wave wave = TowerDefense.getInstance().getCurrentWave();
        if (wave == null) return;
        int strengthen = wave.getStrengthen();
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            Mob mob = CraftMob.SlimeSpilt(afterSize);
            if (mob == null) return;
            mob.strengthen(strengthen);
            mob.spawn(randomOffset(parentLocation,r,0.1));
            mob.setFacingDegree(parentLocation.getYaw());
            moblist.add(mob);
        }
    }

    private Location randomOffset(Location loc, Random r, double offset) {
        return loc.clone().add(r.nextDouble() * offset * 2 - offset,0,r.nextDouble()* offset * 2 - offset);
    }

    private void castCheckpointAngles() {
        for (int i = 1; i < cps.size(); i++) {
            cps.get(i-1).connectTo(cps.get(i));
        }
        cps.get(cps.size()-1).connectTo(getEndPoint());
    }
}
