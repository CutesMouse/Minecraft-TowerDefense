package com.s206megame.towerdefense.effect;

import com.s206megame.towerdefense.utils.MathTool;
import com.s206megame.towerdefense.mobs.Mob;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Override
    public ArrayList<String> getDescription() {
        return new ArrayList<>(Arrays.asList(
                "§6特殊效果: 燃燒 "+ MathTool.rome(level),
                "§7高溫的炙燒使敵人感到窒息,",
                "§7立即對目標造成 §a"+MathTool.round(init,1)+" §7點傷害,",
                "§7並在之後的 §a2 §7秒內,",
                "§7持續對目標造成 §a" + MathTool.round(getBaseDamage(),1) + " §7點的傷害."
        ));
    }

    @Override
    public ArrayList<String> getUpgradeDescription(MobEffect old) {
        if (!(old instanceof FireEffect)) return new ArrayList<>();
        FireEffect effect = ((FireEffect) old);
        return new ArrayList<>(Arrays.asList(
                "§6特殊效果: 燃燒 §7"+ MathTool.rome(effect.level) +" §6(➲" + MathTool.rome(level)+")",
                "§7高溫的炙燒使敵人感到窒息,",
                "§7立即對目標造成 §7"+MathTool.round(effect.init,1)+" §a(➲"+MathTool.round(init,1)+")"+" §7點傷害,",
                "§7並在之後的 §a2 §7秒內,",
                "§7持續對目標造成 §7" + MathTool.round(effect.getBaseDamage(),1) + " §a(➲" + MathTool.round(getBaseDamage(),1)+ ") §7點的傷害."
        ));
    }
}
