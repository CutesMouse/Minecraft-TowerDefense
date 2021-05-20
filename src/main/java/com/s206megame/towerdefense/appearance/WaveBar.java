package com.s206megame.towerdefense.appearance;

import com.s206megame.towerdefense.utils.WaveManager;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;

public class WaveBar {
    BossBar bar;
    public WaveBar(int wave) {
        int maxMob = WaveManager.getWaveData(wave).getMaxMob();
        bar.setTitle("Wave " + wave + "(Total: " + maxMob + " Entities");
        bar.setColor(BarColor.RED);
        bar.setProgress(1);
        bar.setVisible(true);
    }

    public void updateBar(double timeleft)
    {
        double percentage = timeleft / 120.0;
        bar.setProgress(percentage);
    }
}

