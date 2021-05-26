package com.s206megame.towerdefense.commands;

import com.cutesmouse.mgui.guis.StaticGUI;
import com.cutesmouse.mgui.items.GUIItem;
import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.Main;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.map.DesertMap;
import com.s206megame.towerdefense.map.DevelopmentMap;
import com.s206megame.towerdefense.map.Map;
import com.s206megame.towerdefense.utils.TowerType;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Nameable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TDStart implements TDCommandBase {
    @Override
    public String getCommandName() {
        return "start";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("s");
    }

    @Override
    public void run(Player player, String[] arg) {
        if (!player.isOp()) {
            player.sendMessage("§c你沒有權限!");
            return;
        }
        if (TowerDefense.getInstance().hasStarted()) {
            player.sendMessage("§c遊戲已開始!");
        }
        StaticGUI start = new StaticGUI("§a選擇地圖",9);
        final DevelopmentMap developmentMap = new DevelopmentMap();
        final DesertMap desertMap = new DesertMap();
        start.put(3,getMapItem(developmentMap, "Development",Material.WATER_BUCKET));
        start.put(5,getMapItem(desertMap,"Desert",Material.CACTUS));
        start.open(player);
    }
    private GUIItem getMapItem(Map map, String name,Material m) {
        return new StaticGUIItem(m,ChatColor.of(new Color(0xFFEA22))+ "§l"+name,getMapDescription(map))
                .setAction(e -> {
                    e.getPlayer().closeInventory();
                    e.setCancelled(true);
                    Main.map = map;
                    TowerDefense.getInstance().Start();
                });
    }
    private ArrayList<String> getMapDescription(Map map) {
        ArrayList<String> al = new ArrayList<>();
        al.add(ChatColor.of(new Color(0xFF8218)) + "最大建塔上限:");
        al.add(ChatColor.of(new Color(0xFBDAFF)) + " - 3x3: "+ChatColor.of(new Color(0xFF5DB9)) + map.getTowerSlots().stream().filter(p -> p.getType().equals(TowerType.THREE_BY_THREE)).count());
        al.add(ChatColor.of(new Color(0xFBDAFF)) + " - 5x5: "+ChatColor.of(new Color(0xFF5DB9)) + map.getTowerSlots().stream().filter(p -> p.getType().equals(TowerType.FIVE_BY_FIVE)).count());
        return al;
    }
}
