package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.mobs.ChickenJockeyMob;
import com.s206megame.towerdefense.mobs.GolemMob;
import com.s206megame.towerdefense.mobs.WitherMob;
import com.s206megame.towerdefense.mobs.ZombieMob;
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
        Main.map.spawnMob(GolemMob.class);
    }
}
