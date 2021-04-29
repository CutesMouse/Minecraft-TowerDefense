package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;

import java.util.ArrayList;

public abstract class MobEffect {
    private ArrayList<Mob> applied = new ArrayList<>();
    public abstract int getDuration();
    public abstract void tickEvent(Mob target);
    public abstract int getLevel();
    public abstract String getType();

    public ArrayList<Mob> getApplied() {
        return applied;
    }
    public void apply(Mob mob) {
        mob.addEffect(this);
        applied.add(mob);
    }
    public boolean canOverwrite(MobEffect old) {
        if (old.getType().equals(old.getType())) return false;
        if (getLevel() > old.getLevel()) return true;
        if (getDuration() > old.getDuration()) return true;
        return false;
    }
}
