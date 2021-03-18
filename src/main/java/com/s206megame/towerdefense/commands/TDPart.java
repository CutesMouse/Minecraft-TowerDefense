package com.s206megame.towerdefense.commands;

import com.cutesmouse.mgui.guis.StaticGUI;
import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
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
        StaticGUI gui = new StaticGUI("Slimlix",36);
        gui.put(0,new StaticGUIItem(Material.STONE,"slimlix",null,1,true).setAction(e -> {
            e.getPlayer().sendMessage("Hello");
            e.setCancelled(true);
        }));
        gui.put(1, new StaticGUIItem(Material.DIAMOND, "mouse", null, 1, false).setAction(e -> {
            e.getPlayer().getHealth();
            e.setCancelled(true); // not taking out item
        }));
        gui.open(player);
         }
}
