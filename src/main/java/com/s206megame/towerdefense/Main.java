package com.s206megame.towerdefense;

import com.cutesmouse.mgui.guis.StaticGUI;
import com.s206megame.towerdefense.api.ScoreboardManager;
import com.s206megame.towerdefense.appearance.PlaceParticle;
import com.s206megame.towerdefense.commands.*;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

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
        PlaceParticle.init(this);
        ScoreboardManager.init(this);
    }
}
