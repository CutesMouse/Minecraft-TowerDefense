package com.s206megame.towerdefense;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

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
}
