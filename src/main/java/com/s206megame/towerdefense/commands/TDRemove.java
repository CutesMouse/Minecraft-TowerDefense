package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.player.PlayerData;
import com.s206megame.towerdefense.player.PlayerDataManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TDRemove implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "remove";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>();
    }

    @Override
    public void run(Player player, String[] arg) {
        PlayerData r = PlayerDataManager.getPlayerData(player);
        if (r.getSlot() == null) return;
        TowerSlot slot = r.getSlot();
        if (slot.getTower() == null) return;
        slot.removeTower();
    }
}
