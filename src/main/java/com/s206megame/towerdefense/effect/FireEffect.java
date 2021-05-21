package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

public class FireEffect extends MobEffect {
    private int duration = 100;
    private boolean firstApply = true;
    private double base;
    public FireEffect(double base) {
        this.base = base;
    }
    @Override
    public int getDuration() {
        return duration;
    }

    private double getBaseDamage() {
        return base;
    }

    @Override
    public void tickEvent(Mob target) {
        target.setOnFire(true);
        if (firstApply) {
            target.damage(getBaseDamage());
            firstApply = false;
            return;
        }
        if (duration % 20 == 0) {
            target.damage(getBaseDamage() * 0.1);
        }
        duration--;
        if (duration == 0) {
            target.setOnFire(false);
        }
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getType() {
        return "FireEffect";
    }
}
