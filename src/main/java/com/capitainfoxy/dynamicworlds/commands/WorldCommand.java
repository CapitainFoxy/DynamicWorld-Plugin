package com.capitainfoxy.dynamicworlds.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.capitainfoxy.dynamicworlds.managers.WorldManager;
import com.capitainfoxy.dynamicworlds.utils.WorldUtils;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1 && args[0].equalsIgnoreCase("create")) {
                WorldManager.createWorld("custom_world", WorldUtils.getDefaultWorldSettings());
                player.sendMessage("New world 'custom_world' created.");
                return true;
            }
        }
        return false;
    }
}
