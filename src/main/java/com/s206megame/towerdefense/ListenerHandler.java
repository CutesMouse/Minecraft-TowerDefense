package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.TowerType;
import com.s206megame.towerdefense.tower.Direction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
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
        if (isFire(e.getCause()) && e.getEntity().getFireTicks() < 1000) {
            e.getEntity().setFireTicks(0);
            e.setCancelled(true);
        }
        Main.map.getMobList().stream().filter(p -> p.getEntity().equals(e.getEntity())).findFirst().ifPresent(mob -> {
            if (isFire(e.getCause())) {
                e.setDamage(0);
            }
            mob.damage(e.getDamage());
            e.setDamage(0);
        });
    }
    private boolean isFire(EntityDamageEvent.DamageCause cause) {
        return cause.equals(EntityDamageEvent.DamageCause.FIRE) || cause.equals(EntityDamageEvent.DamageCause.FIRE_TICK);
    }
    @EventHandler
    public void disableTNT(EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    /*private Location p1;
    @EventHandler
    public void onTest(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) return;
        /*if (e.getItem() == null) {
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
            e.getPlayer().performCommand(String.format("td tower %d %d %d %d %d %d",p1.getBlockX(),p1.getBlockY(),p1.getBlockZ(),p2.getBlockX(),p2.getBlockY(),p2.getBlockZ()));
            System.out.println("====");
            p1 = null;
        }*/
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
