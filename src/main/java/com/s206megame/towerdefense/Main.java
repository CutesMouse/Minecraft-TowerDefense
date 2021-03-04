package com.s206megame.towerdefense;

import com.s206megame.towerdefense.commands.TDCommandManager;
import com.s206megame.towerdefense.commands.TDPart;
import com.s206megame.towerdefense.commands.TDSetMap;
import com.s206megame.towerdefense.commands.TDStart;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private TDCommandManager CMD_MANAGER;
    @Override
    public void onEnable() {
        CMD_MANAGER = TDCommandManager.getInstance(this);
        CMD_MANAGER.registerArg(new TDStart());
        CMD_MANAGER.registerArg(new TDPart());
        CMD_MANAGER.registerArg(new TDSetMap());
    }
}
