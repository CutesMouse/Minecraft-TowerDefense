package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

public class PoisonousEffect extends MobEffect {
    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public void tickEvent(Mob target) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
