package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

public class FireEffect extends MobEffect {
    private int duration = 100;
    private boolean firstApply = true;
    @Override
    public int getDuration() {
        return duration;
    }

    private double getBaseDamage() {
        return 50;
    }

    @Override
    public void tickEvent(Mob target) {
        target.setOnFire(true);
        if (firstApply) {
            System.out.println("First");
            target.damage(getBaseDamage());
            firstApply = false;
            return;
        }
        if (duration % 20 == 0) {
            target.damage(getBaseDamage() * 0.1);
            System.out.println("Damage");
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
        return null;
    }
}
