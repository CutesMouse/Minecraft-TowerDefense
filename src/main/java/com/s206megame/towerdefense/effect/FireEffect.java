package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

public class FireEffect extends MobEffect {
    private int duration = 40;
    protected int level;
    private boolean firstApply = true;
    private double base;
    private double init;

    public FireEffect(double init, double base,int level) {
        this.base = base;
        this.level = level;
        this.init = init;
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
            target.damage(init);
            firstApply = false;
            return;
        }
        if (duration % 20 == 0) {
            target.damage(getBaseDamage());
        }
        duration--;
        if (duration == 0) {
            target.setOnFire(false);
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getType() {
        return "FireEffect";
    }
}
