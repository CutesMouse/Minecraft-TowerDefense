package com.s206megame.towerdefense.utils;

import com.cutesmouse.mgui.events.PlayerGUIClickEvent;
import com.cutesmouse.mgui.guis.DynamicGUI;
import com.cutesmouse.mgui.guis.StaticGUI;
import com.cutesmouse.mgui.interfaces.ClickAction;
import com.cutesmouse.mgui.items.GUIItem;
import com.cutesmouse.mgui.items.StaticGUIItem;
import com.s206megame.towerdefense.Main;
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
import net.md_5.bungee.api.chat.ClickEvent;
import net.minecraft.server.v1_16_R3.Slot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

        if (slot.getTower() != null) {
            gui.put(22,upgradeItem(slot));
            gui.put(44, new StaticGUIItem(Material.BEDROCK, "§c拆除此建築", new ArrayList<>(Arrays.asList("§a拆除後將會退還一半的建築費用",
                    "§c此功能無法撤回!","","§a您將獲得 §e$" + slot.getTower().getPrice() / 2.0,"","§e點擊拆除!")),
                    1).setAction(c -> removeTower(c,slot)));
            gui.open(player);
            return;
        }
        gui.put(9, new StaticGUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "§b遠程攻擊"
                , Arrays.asList("§f攻擊距離較遠的塔種"), 1).setAction(e -> e.setCancelled(true)));
        gui.put(11, mergeItem(new ArcherTower(), slot));
        gui.put(13, mergeItem(new LongbowTower(), slot));
        gui.put(15, mergeItem(new SniperTower(), slot));
        gui.put(18, new StaticGUIItem(Material.RED_STAINED_GLASS_PANE, "§c強力攻擊",
                Arrays.asList("§f攻擊力較高的塔種"), 1).setAction(e -> e.setCancelled(true)));
        gui.put(20, mergeItem(new PotionTower(), slot));
        gui.put(22,mergeItem(new FireTower(),slot));
        gui.put(24, mergeItem(new ExplosionTower(), slot));
        gui.put(26, mergeItem(new DariusTower(), slot));
        gui.put(27, new StaticGUIItem(Material.GREEN_STAINED_GLASS_PANE, "§2快速攻擊",
                Arrays.asList("§f攻擊頻率較高的塔種"), 1).setAction(e -> e.setCancelled(true)));
        gui.put(29, mergeItem(new SnowballTower(), slot));
        gui.put(31, mergeItem(new CrossbowTower(), slot));
        gui.put(33, mergeItem(new MinigunTower(), slot));
        gui.open(player);
    }

    private static GUIItem upgradeItem(TowerSlot slot) {
        try {
            Tower tower = slot.getTower().getClass().newInstance();
            tower.setLevel(slot.getTower().getLevel() != slot.getTower().getMaxLevel() ? slot.getTower().getLevel() +1 : slot.getTower().getLevel());
            ArrayList<String> intro;
            if (slot.getTower().getLevel() == slot.getTower().getMaxLevel()) {
                intro = tower.getDescriptionLore();
                intro.add("§a★ 已達到最高等級");
            } else {
                intro = tower.getUpgradeDescriptionLore(slot.getTower());
                intro.add("");
                intro.add("§e點擊完成升級!");
            }
            return new StaticGUIItem(tower.getDisplayItem(),slot.getTower().getDescriptionTitle(),intro).setAction(e -> {
                e.setCancelled(true);
                e.getPlayer().closeInventory();
                if (slot.getTower().getLevel() == slot.getTower().getMaxLevel()) {
                    return;
                }
                int cost = tower.getPrice(tower.getLevel());
                if (TowerDefense.getInstance().canAfford(cost)) {
                    slot.getTower().upgrade();
                    sendBuildMessage(e.getPlayer().getName(),tower);
                    TowerDefense.getInstance().removeMoney(cost);
                } else {
                    e.getPlayer().sendMessage("§c你沒有足夠的金錢!");
                }
            });
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static GUIItem mergeItem(Tower tower, TowerSlot slot) {
        ArrayList<String> replace = null;
        if (!slot.getType().equals(tower.getType())) {
            replace = new ArrayList<>(Collections.singletonList("§c✗ 尺寸不相容"));
        }
        if (tower instanceof DariusTower && Main.map.getTowers().stream().anyMatch(p -> p instanceof DariusTower)) {
            replace = new ArrayList<>(Collections.singletonList("§c✗ 已達到最大上限數量"));
        }
        GUIItem item = tower.getGUIItem();
        if (replace != null) item.setItemLore(replace);
        return item.setAction(getAction(tower, slot));
    }

    private static ClickAction getAction(Tower tower, TowerSlot slot) {
        return e -> {
            e.setCancelled(true);
            e.getPlayer().closeInventory();
            if (slot.getTower() != null) return;
            if (!slot.getType().equals(tower.getType())) return;
            if (tower instanceof DariusTower && Main.map.getTowers().stream().anyMatch(p -> p instanceof DariusTower)) return;
            if (!TowerDefense.getInstance().canAfford(tower.getPrice(tower.getLevel()))) {
                e.getPlayer().sendMessage("§c你沒有足夠的金錢!");
                return;
            }
            slot.buildTower(tower);
            sendBuildMessage(e.getPlayer().getName(),tower);
            TowerDefense.getInstance().removeMoney(tower.getPrice(tower.getLevel()));
        };
    }
    private static void removeTower(PlayerGUIClickEvent e, TowerSlot slot) {
        e.setCancelled(true);
        e.getPlayer().closeInventory();
        if (slot.getTower() == null) {
            e.getPlayer().sendMessage("§c找不到目標防禦塔!");
            return;
        }
        double back = slot.getTower().getPrice() / 2D;
        sendRemoveMessage(e.getPlayer().getName(),slot.getTower());
        TowerDefense.getInstance().addMoney(back);
        slot.removeTower();
    }

    private static void sendBuildMessage(String builder, Tower tower) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            String verb = tower.getLevel() == 1 ? "放置" : "升級";
            p.sendMessage("§6" + builder + " §a"+verb+"了 §6" + tower.getTitle());
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
        }
    }
    private static void sendRemoveMessage(String remover, Tower tower) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("§6" + remover + " §c移除了 §6" + tower.getTitle());
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING,1,1);
        }
    }
}
