package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.effect.FireEffect;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TDMobEffect implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "ef";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>();
    }

    @Override
    public void run(Player player, String[] arg) {
        for (Mob m : Main.map.getMobList()) {
            m.addEffect(new FireEffect());
        }
    }
}
