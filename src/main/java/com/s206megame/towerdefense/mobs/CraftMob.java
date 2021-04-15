package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.api.Map;

public abstract class CraftMob implements Mob {
    private static Map getMap() {
        return Main.map;
    }

}
