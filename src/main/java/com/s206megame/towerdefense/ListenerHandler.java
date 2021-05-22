package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.player.PlayerData;
import com.s206megame.towerdefense.player.PlayerDataManager;
import com.s206megame.towerdefense.tower.Direction;
import com.s206megame.towerdefense.utils.TowerPlacingGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ListenerHandler implements Listener {
    private static ArrayList<Consumer<PlayerLoginEvent>> PLES = new ArrayList<>();
    private static ArrayList<Consumer<PlayerItemHeldEvent>> PWHIES = new ArrayList<>();
    public static void registerLoginEvent(Consumer<PlayerLoginEvent> event) {
        PLES.add(event);
    }
    public static void registerPlayerItemHeldEvent(Consumer<PlayerItemHeldEvent> event) {
        PWHIES.add(event);
    }
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        PLES.forEach(i -> i.accept(e));
    }
    @EventHandler
    public void onPlayerSwapHandItem(PlayerItemHeldEvent e) {
        PWHIES.forEach(i -> i.accept(e));
    }
    @EventHandler
    public void onEntityFired(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) return;
        Main.map.getMobList().stream().filter(p -> p.getEntity().equals(e.getEntity())).findFirst()
                .ifPresent(mob -> e.setCancelled(true));
    }
    @EventHandler
    public void disableTNT(EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
    }

    @EventHandler
    public void onTowerPlacing(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ARMOR_STAND)) e.setCancelled(true);
        PlayerData pd = PlayerDataManager.getPlayerData(e.getPlayer());
        if (pd.getSlot() == null) return;
        TowerPlacingGUI.open(e.getPlayer(),pd.getSlot());
        e.setCancelled(true);
    }
    @EventHandler
    public void onSlimeSpilt(SlimeSplitEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onLootDrop(EntityDeathEvent e) {
        if (e.getEntity().getType().equals(EntityType.PLAYER)) return;
        e.getDrops().clear();
    }
    @EventHandler
    public void onEntityAttack(EntityTargetLivingEntityEvent e) {
        if (!e.getEntityType().equals(EntityType.PLAYER)) e.setCancelled(true);
    }
    @EventHandler
    public void onTeleport(EntityTeleportEvent e) {
        if (e.getEntityType().equals(EntityType.ENDERMAN)) e.setCancelled(true);
    }
        /*if (!e.getPlayer().getName().equals("CutesMouse")) return;
        if (e.getClickedBlock() == null) return;
        if (e.getItem() == null) {
            e.setCancelled(true);
            if (p1 == null) {
                p1 = e.getClickedBlock().getLocation();
                e.getPlayer().sendMessage("p1 set!");
                return;
            }
            Location p2 = e.getClickedBlock().getLocation();
            if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) e.getClickedBlock().setType(Material.AIR);
            e.getPlayer().sendMessage("Printed!");
            System.out.println("====");
            e.getPlayer().performCommand(String.format("td tower %d %d %d %d %d %d", p1.getBlockX(), p1.getBlockY(), p1.getBlockZ(), p2.getBlockX(), p2.getBlockY(), p2.getBlockZ()));
            System.out.println("====");
            p1 = null;
        }/*
    }
    /*
        TowerType type = TowerType.THREE_BY_THREE;
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            type = TowerType.FIVE_BY_FIVE;
        }
        Block block = e.getClickedBlock();
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        float pyaw = e.getPlayer().getLocation().getYaw();
        if (pyaw < 0) pyaw += 360;
        Direction dr;
        if (pyaw >= 45 && pyaw < 135) {
            dr = Direction.WEST;
        } else if (pyaw >= 135 && pyaw < 225) {
            dr = Direction.NORTH;
        } else if (pyaw >= 225 && pyaw < 315) {
            dr = Direction.EAST;
        } else {
            dr = Direction.SOUTH;
        }
        e.getPlayer().sendMessage("saved "+type.name() + " on " + x + ", " + y +", " + z + " facing " + dr.name());
        //towerSlots.add(new TowerSlot(new Location(w, -38, 5, -2), TowerType.THREE_BY_THREE));
        System.out.println("towerSlots.add(new TowerSlot(new Location(w, "+x+", "+y+", "+z+"), TowerType."+type.name()+", Direction."+dr.name()+"));");
        e.setCancelled(true);
    }*/
}
