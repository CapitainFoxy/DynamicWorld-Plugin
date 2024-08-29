package com.capitainfoxy.dynamicworlds.utils;

import org.bukkit.configuration.file.FileConfiguration;
import com.capitainfoxy.dynamicworlds.managers.ConfigManager;

public class WorldUtils {
    public static FileConfiguration getDefaultWorldSettings() {
        return ConfigManager.getConfig().getConfigurationSection("defaultWorldSettings");
    }
}
