package com.s206megame.towerdefense.map;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.CheckPoint;
import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.tower.Direction;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class DefaultMap implements Map {
    private static ArrayList<TowerSlot> towerSlots;
    private static ArrayList<Mob> moblist;
    private static World WORLD;

    public DefaultMap() {
        moblist = new ArrayList<>();
        WORLD = Bukkit.getWorlds().get(0);
        // init towerslots
        initTowers(WORLD);
        new BukkitRunnable() {
            @Override
            public void run() {
                tickEvent();
            }
        }.runTaskTimer(Main.getPlugin(Main.class),0L,1L);
    }

    public void tickEvent() {
        if (moblist.size() > 0) {
            for (Mob mob : moblist) {
                if (mob == null) continue;
                mob.onEntityMove();
                mob.updateDisplayName();
                mob.effectUpdate();
            }
        }
    }

    @Override
    public ArrayList<TowerSlot> getTowerSlots() {
        return towerSlots;
    }

    @Override
    public TowerSlot identifyTower(Location loc) {
        return towerSlots.stream().filter(p -> p.isInside(loc)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<Mob> getMobList() {
        return moblist;
    }

    @Override
    public ArrayList<CheckPoint> getCheckpoints() {
        ArrayList<CheckPoint> cps = new ArrayList<>();
        cps.add(new CheckPoint(-46.0,5,-13.0,-78.7));
        cps.add(new CheckPoint(-26.0,5,-9.0,4.8));
        cps.add(new CheckPoint(-27.0,5,3.0,86.8));
        cps.add(new CheckPoint(-45.0,5,4.0,0));
        cps.add(new CheckPoint(-45.0,5,17.0,-90));
        cps.add(new CheckPoint(16.0,5,17.0,-168.7));
        cps.add(new CheckPoint(17.0,5,12.0,-180.0));
        cps.add(new CheckPoint(17.0,5,-46.5,90));
        cps.add(new CheckPoint(-12.5,5,-46.5,0));
        return cps;
    }

    @Override
    public Location getMobSpawnLocation() {
        return new Location(WORLD, -46, 5, -48.5);
    }

    public void spawnMob(Class<? extends Mob> mob) {
        try {
            Mob mobEntity = mob.newInstance();
            mobEntity.spawn(getMobSpawnLocation());
            moblist.add(mobEntity);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void initTowers(World w) {
        towerSlots = new ArrayList<>();
        towerSlots.add(new TowerSlot(new Location(w, -40, 5, -44), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -39), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -36), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -40, 5, -31), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -26), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -23), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -40, 5, -18), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -43), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -40), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -37), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -34), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -31), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -28), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -25), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -22), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -19), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -16), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, -13), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -51, 5, -10), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -50, 5, -7), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -47, 5, -6), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -44, 5, -6), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -6), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -38, 5, -6), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -33, 5, -4), TowerType.FIVE_BY_FIVE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -38, 5, -2), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, -2), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -44, 5, -2), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -47, 5, -2), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -50, 5, -1), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -51, 5, 2), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 5), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 8), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 11), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 14), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -52, 5, 17), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -47, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -44, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -41, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -38, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -35, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -32, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -14, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -11, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -8, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -5, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -2, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 1, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 4, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 7, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 10, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 13, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 16, 5, 22), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 16), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 13), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 10), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 7), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 4), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, 1), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -2), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -5), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -8), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -12), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -15), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -18), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -21), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -24), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -27), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -30), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -33), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -36), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -39), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -42), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -45), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -48), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, 22, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 19, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 16, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 13, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 10, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 7, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 4, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 1, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -2, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -5, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -8, 5, -52), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, 11, 5, -37), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, 10, 5, -32), TowerType.FIVE_BY_FIVE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, 11, 5, -20), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, 10, 5, -15), TowerType.FIVE_BY_FIVE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, 11, 5, -3), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, 10, 5, 2), TowerType.FIVE_BY_FIVE, Direction.EAST));
    }
}
