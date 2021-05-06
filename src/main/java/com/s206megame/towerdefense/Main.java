package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.ScoreboardManager;
import com.s206megame.towerdefense.appearance.PlaceParticle;
import com.s206megame.towerdefense.commands.*;
import com.s206megame.towerdefense.map.DefaultMap;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private TDCommandManager CMD_MANAGER;
    public static DefaultMap map;
    @Override
    public void onEnable() {
        map = new DefaultMap();
        CMD_MANAGER = TDCommandManager.getInstance(this);
        CMD_MANAGER.registerArg(new TDStart());
        CMD_MANAGER.registerArg(new TDPart());
        CMD_MANAGER.registerArg(new TDSetMap());
        CMD_MANAGER.registerArg(new TDEco());
        CMD_MANAGER.registerArg(new TDMobTest());
        CMD_MANAGER.registerArg(new TDRemoveMobs());
        CMD_MANAGER.registerArg(new TDMobEffect());
        CMD_MANAGER.registerArg(new TDTowerTools());
        getServer().getPluginManager().registerEvents(new ListenerHandler(),this);
        PlaceParticle.init(this);
        ScoreboardManager.init(this);
    }
}
