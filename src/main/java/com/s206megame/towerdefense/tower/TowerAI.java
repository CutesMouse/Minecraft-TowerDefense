package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.api.Map;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Location;

import java.util.ArrayList;

public interface TowerAI {
    ArrayList<Mob> getTarget(Map map);
    boolean isValid(Mob mob);
}
