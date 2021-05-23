package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.api.MathTool;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.Particle;

import java.util.ArrayList;
import java.util.Arrays;

public class SlownessEffect extends MobEffect {
    private int duration = 20;
    protected int level;
    public SlownessEffect(int level) {
        this.level = level;
    }
    public SlownessEffect(int level, int duration) {
        this.level = level;
        this.duration = duration;
    }

    @Override
    public ArrayList<String> getDescription() {
        return new ArrayList<>(Arrays.asList(
                "§6物品效果: 緩速 "+ MathTool.rome(level),
                "§7將敵人緩速 §a" + MathTool.toPercentage(1-getSlownessRatio())+"§7,",
                "§7持續 §a" + MathTool.round(duration/20.0,1) +" §7秒."
        ));
    }

    @Override
    public ArrayList<String> getUpgradeDescription(MobEffect old) {
        if (!(old instanceof SlownessEffect)) return new ArrayList<>();
        SlownessEffect effect = ((SlownessEffect) old);
        return new ArrayList<>(Arrays.asList(
                "§6物品效果: 緩速 §7"+ MathTool.rome(effect.level) + " §6(➲" + MathTool.rome(level)+")",
                "§7將敵人緩速 §7" + MathTool.toPercentage(1-effect.getSlownessRatio()) + " §a(➲" + MathTool.toPercentage(1-getSlownessRatio())+")§7,",
                "§7持續 §7" + MathTool.round(effect.duration/20.0,1) +" §a(➲"+MathTool.round(duration / 20.0,1)+") §7秒."
        ));
    }
    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void tickEvent(Mob target) {
        target.setSlowness(getSlownessRatio());
        target.getEntity().getWorld().spawnParticle(Particle.SNOWBALL,target.getEntity().getLocation(),5);
        duration--;
        if (duration == 0) target.setSlowness(1);
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
