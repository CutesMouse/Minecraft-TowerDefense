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
        StaticGUI gui = new StaticGUI("§l防禦塔建造",45);
        for (int i = 0; i < 9; i++) {
            gui.put(i,new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE,"§r",null).setAction(e -> e.setCancelled(true)));
            gui.put(i+36,new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE,"§r",null).setAction(e -> e.setCancelled(true)));
        }
        gui.put(9,new StaticGUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE,"§b遠程攻擊",Arrays.asList("§f攻擊距離較遠的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.put(11,new StaticGUIItem(Material.BOW,"§b弓箭手塔",Arrays.asList("§f冷血的弓箭手躲在堅固的堡壘中", "準確射殺迎面而來的敵人",""),1).setAction(e -> e.setCancelled(true)));
        gui.put(18,new StaticGUIItem(Material.RED_STAINED_GLASS_PANE,"§c強力攻擊",Arrays.asList("§f攻擊力較高的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.put(27,new StaticGUIItem(Material.GREEN_STAINED_GLASS_PANE,"§2快速攻擊",Arrays.asList("§f攻擊頻率較高的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.open(player);
         }
}
