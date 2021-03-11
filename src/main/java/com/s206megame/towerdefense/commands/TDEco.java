package com.s206megame.towerdefense.commands;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDEco implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "eco";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("economy","money","balance");
    }

    @Override
    public void run(Player sender, String[] arg) {
        if (arg.length == 0) {
            sender.sendMessage("§6用法: §f/td eco <玩家> [set | add | remove]");
            return;
        }
        String playerName = arg[0];
        if (arg.length == 1) { // 查詢玩家剩餘經濟
            sender.sendMessage("該名玩家持有金額: ");
        }
    }
}
