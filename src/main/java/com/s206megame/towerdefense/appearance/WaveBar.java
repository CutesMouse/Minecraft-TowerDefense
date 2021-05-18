package com.s206megame.towerdefense.appearance;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;

public class WaveBar {
    BossBar bar;
    public WaveBar(int wave) {
        bar.setTitle("Wave " + wave);
        bar.setColor(BarColor.PINK);
        bar.setProgress(1);
    }

    public void updateBar(double timeleft)
    {
        double percentage = timeleft / 120.0;
        bar.setProgress(percentage);
    }
}

