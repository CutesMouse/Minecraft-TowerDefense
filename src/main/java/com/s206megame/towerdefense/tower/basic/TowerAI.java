package com.s206megame.towerdefense.tower.basic;

import com.s206megame.towerdefense.map.basic.Map;
import com.s206megame.towerdefense.mobs.basic.Mob;

import java.util.ArrayList;

public interface TowerAI {
    ArrayList<Mob> getTarget(Map map);
    boolean isValid(Mob mob);
}
