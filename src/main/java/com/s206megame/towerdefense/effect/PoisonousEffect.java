package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.utils.MathTool;
import com.s206megame.towerdefense.mobs.basic.Mob;
import org.bukkit.Particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PoisonousEffect extends MobEffect {
    protected int level;
    protected int duration;
    protected double damage;
    public PoisonousEffect(double damage, int level) {
        this.level = level;
        this.damage = damage;
        duration = 100;
    }
    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void tickEvent(Mob target) {
        if (duration % 20 == 0) {
            Random r = new Random();
            target.getEntity().getWorld().spawnParticle(Particle.DAMAGE_INDICATOR,
                    target.getEntity().getLocation().add(-1 + r.nextDouble() * 2,r.nextDouble(),-1 + 2 *r.nextDouble()),5);
            target.damage(damage * 0.2);
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

    @Override
    public ArrayList<String> getDescription() {
        return new ArrayList<>(Arrays.asList(
                "§6特殊效果: 中毒 "+ MathTool.rome(level),
                "§7將敵人置於極度危險之中,",
                "§7對目標造成每秒 §a" + MathTool.round(damage * 0.2,1) + " §7點的傷害,",
                "§7持續 §a" + MathTool.round(duration/20.0,1) +" §7秒."
        ));
    }

    @Override
    public ArrayList<String> getUpgradeDescription(MobEffect old) {
        if (!(old instanceof PoisonousEffect)) return new ArrayList<>();
        PoisonousEffect effect = ((PoisonousEffect) old);
        return new ArrayList<>(Arrays.asList(
                "§6特殊效果: 中毒 §7"+ MathTool.rome(effect.level) + " §6(➲" + MathTool.rome(level)+")",
                "§7將敵人置於極度危險之中,",
                "§7對目標造成每秒 §7" + MathTool.round(effect.damage * 0.2,1) + " §a(➲" + MathTool.round(damage * 0.2,1)+") §7點的傷害,",
                "§7持續 §a" + MathTool.round(effect.duration/20.0,1)+" §7秒."
        ));
    }
}
