package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.player.PlayerData;
import com.s206megame.towerdefense.player.PlayerDataManager;
import org.bukkit.Bukkit;
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
        if (!sender.isOp()) {
            sender.sendMessage("§c沒有權限!");
        }
        if (arg.length == 0) {
            sender.sendMessage("§6用法: §f/td eco <玩家> <set | add | remove>");
            return;
        }
        String playerName = arg[0];
        Player player = Bukkit.getPlayer(playerName);
        if (player == null) {
            sender.sendMessage("§4找不到目標玩家!");
            return;
        }
        PlayerData data = PlayerDataManager.getPlayerData(player);
        if (arg.length == 1) {
            return;
        }
        if (arg.length != 3) {
            sender.sendMessage("§6用法: /td eco <玩家> <set | add | remove> <金額>");
            return;
        }
        if (!arg[2].matches("-\\d+\\.\\d+|\\d+\\.\\d+|\\d+")) {
            sender.sendMessage("§a金額必須為數字或浮點數!");
            return;
        }
        double amount = Double.parseDouble(arg[2]);
        switch (arg[1].toLowerCase()) {
            case "set":
                data.setBalance(amount);
                break;
            case "add":
                data.deposit(amount);
                break;
            case "remove":
                data.withdraw(amount);
                break;
            default:
                sender.sendMessage("§c不存在的引數!");
                return;
        }
        sender.sendMessage("§a已更新經濟! 現在有 " + TowerDefense.getInstance().getMoney() + " 元!");
    }
}
