package com.s206megame.towerdefense;

import com.s206megame.towerdefense.api.ScoreboardManager;
import com.s206megame.towerdefense.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private TDCommandManager CMD_MANAGER;
    @Override
    public void onEnable() {
        CMD_MANAGER = TDCommandManager.getInstance(this);
        CMD_MANAGER.registerArg(new TDStart());
        CMD_MANAGER.registerArg(new TDPart());
        CMD_MANAGER.registerArg(new TDSetMap());
        CMD_MANAGER.registerArg(new TDEco());
        getServer().getPluginManager().registerEvents(new ListenerHandler(),this);
        ScoreboardManager.init(this);
    }
}
