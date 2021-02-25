package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TDCommandManager implements CommandExecutor {
    private static TDCommandManager INST;
    private ArrayList<TDCommandBase> commands;
    public static TDCommandManager getInstance(Main plugin) {
        if (INST == null) {
            INST = new TDCommandManager();
            plugin.getCommand("towerdefense").setExecutor(INST);
        }
        return INST;
    }

    private TDCommandManager() {
        commands = new ArrayList<>();
    }

    public void registerArg(TDCommandBase base) {
        commands.add(base);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (args.length == 0) {
            sendUsage(((Player) sender));
            return true;
        }
        TDCommandBase target = commands.stream().filter(p -> p.getCommandName().equals(args[0]) || p.getAliases().contains(args[0])).findFirst().orElse(null);
        if (target == null) {
            sendUsage(((Player) sender));
            return true;
        }
        String[] reduced = Arrays.stream(args).skip(1).toArray(String[]::new);
        target.run(((Player) sender),reduced);
        return true;
    }
    private void sendUsage(Player player) {
        player.sendMessage("§6用法: §f/td ["+commands.stream().map(TDCommandBase::getCommandName).map(s -> " | " + s).collect(Collectors.joining()).substring(3)+"]");
    }
}
