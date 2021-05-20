package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.Main;

import java.util.HashMap;

public class Wave {
    HashMap<Class<? extends Mob>, Integer> content;
    public Wave()
    {
        content = new HashMap<>();
    }
    public void spawnWave()
    {
        for (Class<? extends Mob> mobtype : content.keySet()) {
            Main.map.spawnMob(mobtype);
        }

    }

    public void addMob(Class<? extends Mob> mobtype, int amount) {
        content.put(mobtype, amount);
    }

}
