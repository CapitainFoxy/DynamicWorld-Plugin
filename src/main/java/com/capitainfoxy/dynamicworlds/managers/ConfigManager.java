package com.capitainfoxy.dynamicworlds.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin plugin) {
        ConfigManager.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public static FileConfiguration getConfig() {
        return plugin.getConfig();
    }
}
