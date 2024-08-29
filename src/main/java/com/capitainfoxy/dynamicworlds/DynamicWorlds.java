package com.capitainfoxy.dynamicworlds;

import org.bukkit.plugin.java.JavaPlugin;
import com.capitainfoxy.dynamicworlds.commands.WorldCommand;
import com.capitainfoxy.dynamicworlds.managers.ConfigManager;
import com.capitainfoxy.dynamicworlds.managers.WorldManager;

public class DynamicWorlds extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("world").setExecutor(new WorldCommand());
        ConfigManager.initialize(this);
        WorldManager.initialize(this);
    }

    @Override
    public void onDisable() {
        WorldManager.unloadAllWorlds();
    }
}
