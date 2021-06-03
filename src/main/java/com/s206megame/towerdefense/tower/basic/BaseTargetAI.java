package com.s206megame.towerdefense.tower.basic;

import com.s206megame.towerdefense.map.basic.Map;
import com.s206megame.towerdefense.mobs.basic.Mob;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BaseTargetAI implements TowerAI {
    private double range;
    private Tower tower;
    public BaseTargetAI(Tower tower) {
        this.range = tower.getRange();
        this.tower = tower;
    }
    @Override
    public ArrayList<Mob> getTarget(Map map) {
        return map.getMobList().stream()
                .filter(this::isValid) // 判斷怪物與防禦塔距離是否小於射程
                .sorted(Comparator.comparing(p -> p.getEntity().getLocation()
                        .distance(tower.getSlot().getCenter())))
                .limit(tower.getMaxTargetAmount())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean isValid(Mob mob) {
        return tower.getSlot().getCenter().distance(mob.getEntity().getLocation()) <= range;
    }
}
