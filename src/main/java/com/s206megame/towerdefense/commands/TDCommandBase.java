package com.s206megame.towerdefense.commands;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.function.BiConsumer;

public interface TDCommandBase {
    String getCommandName();
    List<String> getAliases();
    void run(Player player, String[] arg);
}
