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
        if (arg.length != 2) {
            sender.sendMessage("§6用法: §f/td eco <set | add | remove> <金額>");
            return;
        }
        if (!arg[1].matches("-\\d+\\.\\d+|\\d+\\.\\d+|\\d+")) {
            sender.sendMessage("§a金額必須為數字或浮點數!");
            return;
        }
        double amount = Double.parseDouble(arg[1]);
        switch (arg[0].toLowerCase()) {
            case "set":
                TowerDefense.getInstance().setMoney(amount);
                break;
            case "add":
                TowerDefense.getInstance().addMoney(amount);
                break;
            case "remove":
                TowerDefense.getInstance().removeMoney(amount);
                break;
            default:
                sender.sendMessage("§c不存在的引數!");
                return;
        }
        sender.sendMessage("§a已更新經濟! 現在有 " + TowerDefense.getInstance().getMoney() + " 元!");
    }
}
