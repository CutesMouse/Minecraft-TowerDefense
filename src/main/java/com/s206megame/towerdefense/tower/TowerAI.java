package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.map.Map;
import com.s206megame.towerdefense.mobs.Mob;

import java.util.ArrayList;

public interface TowerAI {
    ArrayList<Mob> getTarget(Map map);
    boolean isValid(Mob mob);
}
