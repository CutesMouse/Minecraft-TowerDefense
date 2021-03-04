package com.s206megame.towerdefense.commands;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDSetMap implements TDCommandBase {

    @Override
    public String getCommandName() {return "setmap";}

    @Override
    public List<String> getAliases() {return Arrays.asList("map"); }

    @Override
    public void run(Player player, String[] arg) {
        player.sendMessage("Map has been set to " + arg[0]);
    }
}
