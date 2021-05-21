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
        StaticGUI gui = new StaticGUI("§2防禦塔建造", 9 * 5);
        for (int i = 0; i < 9; i++) {
            gui.put(i, new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE, "§r", null).setAction(e -> e.setCancelled(true)));
            gui.put(i + 36, new StaticGUIItem(Material.BLACK_STAINED_GLASS_PANE, "§r", null).setAction(e -> e.setCancelled(true)));
        }
        boolean printItem = true;
        if (slot.getTower() != null) {
            if (slot.getTower().getLevel() == slot.getTower().getMaxLevel()) {
                Tower tower = slot.getTower();
                ArrayList<String> descriptionLore = tower.getDescriptionLore();
                descriptionLore.add("§a★ 最高等級");
                gui.put(22, new StaticGUIItem(tower.getDisplayItem(),tower.getTitle(),descriptionLore));
                printItem = false;
            }
            gui.put(44, new StaticGUIItem(Material.BEDROCK, "§c拆除此建築", new ArrayList<>(Arrays.asList("§a拆除後將會退還一半的建築費用", "§a此功能無法撤回!")),
                    1).setAction(c -> {
                player.closeInventory();
                if (slot.getTower() == null) {
                    player.sendMessage("§c塔已被拆除!");
                    return;
                }
                TowerDefense.getInstance().addMoney(slot.getTower().getPrice(slot.getTower().getLevel()) / 2D);
                slot.removeTower();
                c.setCancelled(true);
            }));
        }
        if (printItem) {
            gui.put(9, new StaticGUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "§b遠程攻擊"
                    , Arrays.asList("§f攻擊距離較遠的塔種"), 1).setAction(e -> e.setCancelled(true)));
            gui.put(11, mergeItem(new ArcherTower(), slot));
            gui.put(13, mergeItem(new LongbowTower(), slot));
            gui.put(15, mergeItem(new SniperTower(), slot));
            gui.put(18, new StaticGUIItem(Material.RED_STAINED_GLASS_PANE, "§c強力攻擊",
                    Arrays.asList("§f攻擊力較高的塔種"), 1).setAction(e -> e.setCancelled(true)));
            gui.put(20, mergeItem(new PotionTower(), slot));
            gui.put(22, mergeItem(new FireTower(), slot));
            gui.put(24, mergeItem(new ExplosionTower(), slot));
            gui.put(26, mergeItem(new DariusTower(), slot));
            gui.put(27, new StaticGUIItem(Material.GREEN_STAINED_GLASS_PANE, "§2快速攻擊",
                    Arrays.asList("§f攻擊頻率較高的塔種"), 1).setAction(e -> e.setCancelled(true)));
            gui.put(29, mergeItem(new SnowballTower(), slot));
            gui.put(31, mergeItem(new CrossbowTower(), slot));
            gui.put(33, mergeItem(new MinigunTower(), slot));

        }
        gui.open(player);
    }

    private static GUIItem mergeItem(Tower tower, TowerSlot slot) {
        ArrayList<String> replace = null;
        if (!slot.getType().equals(tower.getType())) {
            replace = new ArrayList<>(Collections.singletonList("§c✗ 尺寸不相容"));
        }
        if (slot.getTower() != null) {
            if (slot.getTower().getClass().getSimpleName().equals(tower.getClass().getSimpleName())) {
                if (slot.getTower().getLevel() == slot.getTower().getMaxLevel()) {
                    replace = new ArrayList<>(Collections.singletonList("§a★ 最高等級"));
                } else tower.setLevel(slot.getTower().getLevel() + 1);
            } else {
                replace = new ArrayList<>(Collections.singletonList("§c✗ 已建造其他種類的塔"));
            }
        }
        GUIItem item = tower.getGUIItem();
        if (replace != null) item.setItemLore(replace);
        return item.setAction(getAction(tower, slot));
    }

    private static ClickAction getAction(Tower tower, TowerSlot slot) {
        return e -> {
            e.setCancelled(true);
            e.getPlayer().closeInventory();
            if (!slot.getType().equals(tower.getType())) {
                return;
            }
            if (slot.getTower() != null) {
                if (slot.getTower().getClass().getSimpleName().equals(tower.getClass().getSimpleName())) {
                    if (slot.getTower().getLevel() == slot.getTower().getMaxLevel()) return;
                    TowerDefense.getInstance().removeMoney(tower.getPrice(tower.getLevel()+1));
                    slot.getTower().upgrade();
                }
                return;
            }
            slot.buildTower(tower);
            TowerDefense.getInstance().removeMoney(tower.getPrice(tower.getLevel()));
        };
    }
}
