package com.s206megame.towerdefense.commands;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDStart implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "start";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("s");
    }

    @Override
    public void run(Player player, String[] arg) {
        player.sendMessage("test");
    }
}