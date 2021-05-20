package com.s206megame.towerdefense.utils;

import com.cutesmouse.mgui.guis.DynamicGUI;
import com.cutesmouse.mgui.guis.StaticGUI;
import com.cutesmouse.mgui.interfaces.ClickAction;
import com.cutesmouse.mgui.items.GUIItem;
import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.TowerDefense;
import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.player.PlayerDataManager;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.tower.attack.DariusTower;
import com.s206megame.towerdefense.tower.attack.ExplosionTower;
import com.s206megame.towerdefense.tower.attack.FireTower;
import com.s206megame.towerdefense.tower.attack.PotionTower;
import com.s206megame.towerdefense.tower.range.ArcherTower;
import com.s206megame.towerdefense.tower.range.LongbowTower;
import com.s206megame.towerdefense.tower.range.SniperTower;
import com.s206megame.towerdefense.tower.speed.CrossbowTower;
import com.s206megame.towerdefense.tower.speed.MinigunTower;
import com.s206megame.towerdefense.tower.speed.SnowballTower;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TowerPlacingGUI {
    public static void open(Player player, TowerSlot slot) {
        StaticGUI gui = new StaticGUI("§2防禦塔建造",9*4);
        for (int i = 0; i < 9; i++) {
            gui.put(i,new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE,"§r",null).setAction(e -> e.setCancelled(true)));
            gui.put(i+36,new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE,"§r",null).setAction(e -> e.setCancelled(true)));
        }
        gui.put(9,new StaticGUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE,"§b遠程攻擊", Arrays.asList("§f攻擊距離較遠的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.put(11, mergeItem(new ArcherTower(),slot));
        gui.put(13, mergeItem(new LongbowTower(),slot));
        gui.put(15, mergeItem(new SniperTower(),slot));
        gui.put(18, new StaticGUIItem(Material.RED_STAINED_GLASS_PANE,"§c強力攻擊",Arrays.asList("§f攻擊力較高的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.put(20, mergeItem(new PotionTower(),slot));
        gui.put(22, mergeItem(new FireTower(),slot));
        gui.put(24, mergeItem(new ExplosionTower(),slot));
        gui.put(26, mergeItem(new DariusTower(),slot));
        gui.put(27, new StaticGUIItem(Material.GREEN_STAINED_GLASS_PANE,"§2快速攻擊",Arrays.asList("§f攻擊頻率較高的塔種"),1).setAction(e -> e.setCancelled(true)));
        gui.put(29, mergeItem(new SnowballTower(),slot));
        gui.put(31, mergeItem(new MinigunTower(),slot));
        gui.put(33, mergeItem(new CrossbowTower(),slot));
        gui.setOwner(player);
        gui.open(player);
    }
    private static GUIItem mergeItem(Tower tower, TowerSlot slot) {
        GUIItem item = tower.getGUIItem();
        if (!slot.getType().equals(tower.getType())) {
            item.setItemLore(new ArrayList<>(Collections.singletonList("§c✗ 尺寸不相容")));
        }
        if (slot.getTower() != null) {
            if (slot.getTower().getClass().getSimpleName().equals(tower.getClass().getSimpleName())) {
                tower.setLevel(slot.getTower().getLevel()+1);
            } else {
                item.setItemLore(new ArrayList<>(Collections.singletonList("§c✗ 已建造其他種類的塔")));
            }
        }
        return item.setAction(getAction(tower, slot));
    }
    private static ClickAction getAction(Tower tower, TowerSlot slot) {
        return e -> {
            e.setCancelled(true);
            if (!slot.getType().equals(tower.getType())) {
                return;
            }
            if (slot.getTower() != null) {
                if (slot.getTower().getClass().getSimpleName().equals(tower.getClass().getSimpleName())) {
                    //slot.getTower() UPGRADE
                }
                return;
            }
            slot.buildTower(tower);
            TowerDefense.getInstance().removeMoney(tower.getPrice(tower.getLevel()));
        };
    }
}
