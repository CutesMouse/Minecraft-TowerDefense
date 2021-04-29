package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.Mob;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDRemoveMobs implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "killmob";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("km","kmob");
    }

    @Override
    public void run(Player player, String[] arg) {
        for (Mob mob : Main.map.getMobList()) {
            mob.kill();
        }
    }
}
