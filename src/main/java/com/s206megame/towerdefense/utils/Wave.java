package com.s206megame.towerdefense.utils;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Wave {
    private HashMap<Class<? extends Mob>, Integer> content; //整波怪物的完整資料
    public Wave() {
        content = new HashMap<>();
        maxMob = 0;
    }

    private int process; //目前召喚了幾隻怪物
    private int maxMob; //最多有幾隻怪物
    private boolean started; //是否開始召喚了
    private boolean thread_end; //是否召喚完成
    private ArrayList<Mob> spawnedMobs; //已經召喚的怪物列表 ((可以方便我們知道怪物死了沒
    private LinkedList<Class<? extends Mob>> QUEUE; //召喚序列


    public void spawnWave() {
        started = true;
        thread_end = false;
        process = 0;
        spawnedMobs = new ArrayList<>();
        QUEUE = new LinkedList<>();
        for (Class<? extends Mob> mobType : content.keySet()) {
            int amount = content.get(mobType);
            for (int i = 0; i < amount ; i++) QUEUE.add(mobType);
        } // 建立怪物召喚序列
        new BukkitRunnable() {
            @Override
            public void run() {
                if (QUEUE.size() == 0) {
                    thread_end = true;
                    this.cancel();
                    return;
                }
                Class<? extends Mob> first = QUEUE.poll();// 每次往序列的下個元素前進
                spawnedMobs.add(Main.map.spawnMob(first));// 召喚怪物
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
