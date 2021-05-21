package com.s206megame.towerdefense.utils;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Wave {
    private int strengthen;
    public enum EndReason {
        OUT_OF_TIME,MOB_CLEARED
    }
    private HashMap<Class<? extends Mob>, Integer> content; //整波怪物的完整資料
    private int wave;
    public Wave(int wave) {
        content = new HashMap<>();
        this.wave = wave;
        maxMob = 0;
        strengthen = 0;
    }

    public int getWave() {
        return wave;
    }

    public Wave strengthen(int l) {
        strengthen = l;
        return this;
    }

    private EndReason endReason;
    private int process; //目前召喚了幾隻怪物
    private int maxMob; //最多有幾隻怪物
    private boolean started; //是否開始召喚了
    private boolean thread_end; //是否召喚完成
    private ArrayList<Mob> spawnedMobs; //已經召喚的怪物列表 ((可以方便我們知道怪物死了沒
    private LinkedList<Class<? extends Mob>> QUEUE; //召喚序列
    private long start_time; //完成召喚的時間


    public void spawnWave() {
        started = true;
        thread_end = false;
        process = 0;
        spawnedMobs = new ArrayList<>();
        QUEUE = new LinkedList<>();
        for (Class<? extends Mob> mobType : content.keySet()) {
            int amount = content.get(mobType);
            for (int i = 0; i < amount ; i++) QUEUE.add(mobType);
        }
        Collections.shuffle(QUEUE);
        // 建立怪物召喚序列
        new BukkitRunnable() {
            @Override
            public void run() {
                if (QUEUE.size() == 0) {
                    start_time = System.currentTimeMillis();
                    thread_end = true;
                    this.cancel();
                    return;
                }
                Class<? extends Mob> first = QUEUE.poll();// 每次往序列的下個元素前進
                Mob mob = Main.map.spawnMob(first);
                mob.strengthen(strengthen);
                spawnedMobs.add(mob);// 召喚怪物
                process++;
            }
        }.runTaskTimer(Main.getProvidingPlugin(Main.class),0L,20L);

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
        if (spawnedMobs.stream().noneMatch(Mob::isAlive)) {
            endReason = EndReason.MOB_CLEARED;
            return true;
        }
        if (getTimeLeft() < 0) {
            endReason = EndReason.OUT_OF_TIME;
            return true;
        }
        return false;
    }

    public EndReason getEndReason() {
        return endReason;
    }

    public int getMobLeft() {
        if (spawnedMobs == null) return 0;
        return (int) spawnedMobs.stream().filter(Mob::isAlive).count();
    }

    public boolean isThread_end() {
        return thread_end;
    }

    public long getTimeLeft() {
        return 1000 * 120 - (System.currentTimeMillis() - start_time);
    }
}
