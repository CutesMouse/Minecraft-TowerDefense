package com.s206megame.towerdefense;

import com.s206megame.towerdefense.map.DesertMap;
import com.s206megame.towerdefense.map.Map;
import com.s206megame.towerdefense.appearance.WaveBar;
import com.s206megame.towerdefense.commands.*;
import com.s206megame.towerdefense.mobs.Mob;
import com.s206megame.towerdefense.tower.Tower;
import com.s206megame.towerdefense.utils.HoveringText;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private TDCommandManager CMD_MANAGER;
    public static Map map;
    @Override
    public void onEnable() {
        map = new DesertMap();
        CMD_MANAGER = TDCommandManager.getInstance(this);
        CMD_MANAGER.registerArg(new TDStart());
        CMD_MANAGER.registerArg(new TDEco());
        getServer().getPluginManager().registerEvents(new ListenerHandler(),this);
    }

    @Override
    public void onDisable() {
        for (Tower t : map.getTowers()) {
            t.remove();
        }
        for (Mob mob : map.getMobList()) {
            mob.kill();
        }
        WaveBar.destroy();
        HoveringText.clear();
    }
}
