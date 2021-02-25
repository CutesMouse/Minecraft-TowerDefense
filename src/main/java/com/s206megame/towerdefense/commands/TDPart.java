package com.s206megame.towerdefense.commands;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TDPart implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "part";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList();
    }

    @Override
    public void run(Player player, String[] arg) {
        Location cl = player.getEyeLocation();
        cl.getDirection().normalize();
        for (int i = 1; i <= 100; i++) {
            cl.getWorld().spawnParticle(Particle.ASH,cl.clone().add(cl.getDirection().normalize().multiply(i)),1);
        }
    }
}
