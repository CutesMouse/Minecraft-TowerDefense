package com.s206megame.towerdefense;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ListenerHandler implements Listener {
    private static ArrayList<Consumer<PlayerLoginEvent>> PLES = new ArrayList<>();
    public static void registerLoginEvent(Consumer<PlayerLoginEvent> event) {
        PLES.add(event);
    }
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        PLES.forEach(i -> i.accept(e));
    }
}
