package com.s206megame.towerdefense.utils;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Wave {
    private HashMap<Class<? extends Mob>, Integer> content;
    public Wave() {
        content = new HashMap<>();
        maxMob = 0;
    }

    private int process;
    private int maxMob;
    private boolean started;
    private boolean thread_end;
    private ArrayList<Mob> spawnedMobs;
    private LinkedList<Class<? extends Mob>> QUEUE;


    public void spawnWave() {
        started = true;
        thread_end = false;
        process = 0;
        spawnedMobs = new ArrayList<>();
        QUEUE = new LinkedList<>(content.keySet());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (QUEUE.size() == 0) {
                    thread_end = true;
                    this.cancel();
                    return;
                }
                Class<? extends Mob> first = QUEUE.poll();
                spawnedMobs.add(Main.map.spawnMob(first));
                process++;
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,10L);

    }

    public void append(Class<? extends Mob> mobtype, int amount) {
        content.put(mobtype, amount);
        maxMob += amount;
    }

    public int getMaxMob() {
        return maxMob;
    }

    public int getProcess() {
        return process;
    }

    public boolean hasEnded() {
        if (!thread_end) return false;
        return spawnedMobs.stream().noneMatch(Mob::isAlive);
    }
}
