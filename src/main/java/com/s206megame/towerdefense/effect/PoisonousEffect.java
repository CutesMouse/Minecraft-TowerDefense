package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Particle;

import java.util.Random;

public class PoisonousEffect extends MobEffect {
    protected int level;
    protected int duration;
    protected double damage;
    public PoisonousEffect(double damage, int level) {
        this.level = level;
        this.damage = damage;
        duration = getDuration();
    }
    @Override
    public int getDuration() {
        return 20;
    }

    @Override
    public void tickEvent(Mob target) {
        target.setOnFire(true);
        if (duration % 20 == 0) {
            Random r = new Random();
            target.getEntity().getWorld().spawnParticle(Particle.DAMAGE_INDICATOR,
                    target.getEntity().getLocation().add(-1 + r.nextDouble() * 2,r.nextDouble(),-1 + 2 *r.nextDouble()),5);
            target.damage(damage * 0.1);
        }
        duration--;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getType() {
        return "PoisonousEffect";
    }
}
