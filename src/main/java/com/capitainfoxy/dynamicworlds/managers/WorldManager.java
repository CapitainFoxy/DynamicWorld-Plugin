package com.capitainfoxy.dynamicworlds.managers;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;

public class WorldManager {
    private static JavaPlugin plugin;
    private static final Map<String, World> loadedWorlds = new HashMap<>();

    public static void initialize(JavaPlugin plugin) {
        WorldManager.plugin = plugin;
    }

    public static void createWorld(String worldName, FileConfiguration settings) {
        WorldCreator creator = new WorldCreator(worldName);
        creator.environment(World.Environment.valueOf(settings.getString("environment")));
        creator.type(WorldType.valueOf(settings.getString("worldType")));
        World world = creator.createWorld();
        loadedWorlds.put(worldName, world);
    }

    public static void unloadAllWorlds() {
        for (World world : loadedWorlds.values()) {
            Bukkit.unloadWorld(world, false);
        }
        loadedWorlds.clear();
    }
}
