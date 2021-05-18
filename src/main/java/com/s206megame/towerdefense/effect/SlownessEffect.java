package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

public class SlownessEffect extends MobEffect {
    private int duration = 20;
    protected int level;
    public SlownessEffect(int level) {
        this.level = level;
    }
    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void tickEvent(Mob target) {
        target.setSnowness(getSlownessRatio());
        duration--;
        if (duration == 0) target.setSnowness(1);
    }

    @Override
    public int getLevel() {
        return level;
    }

    private double getSlownessRatio() {
        switch (level) {
            case 1:
                return 0.8;
            case 2:
                return 0.7;
            case 3:
                return 0.6;
        }
        return 1;
    }

    @Override
    public String getType() {
        return "SlownessEffect";
    }
}
