package com.capitainfoxy.dynamicworlds.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {

    public static FileConfiguration loadConfig(JavaPlugin plugin, String fileName) {
        File configFile = new File(plugin.getDataFolder(), fileName);
        if (!configFile.exists()) {
            plugin.saveResource(fileName, false);
        }
        return YamlConfiguration.loadConfiguration(configFile);
    }

    public static void saveConfig(FileConfiguration config, String fileName, JavaPlugin plugin) {
        try {
            config.save(new File(plugin.getDataFolder(), fileName));
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save config to " + fileName);
        }
    }

    public static void reloadConfig(JavaPlugin plugin, String fileName) {
        FileConfiguration config = loadConfig(plugin, fileName);
        plugin.getLogger().info("Configuration reloaded: " + fileName);
    }
}
