package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.*;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDMobTest implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "mob";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList();
    }

    @Override
    public void run(Player player, String[] arg) {
        Main.map.spawnMob(EndermanMob.class);
    }
}
