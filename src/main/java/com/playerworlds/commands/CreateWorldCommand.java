package com.playerworlds.commands;

import com.playerworlds.managers.WorldManager;
import com.playerworlds.storage.WorldRegistry;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CreateWorldCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) || args.length != 2) return false;
        Player player = (Player) sender;
        String name = args[0], password = args[1];

        if (WorldRegistry.ownsWorld(player.getName())) {
            player.sendMessage("§cYou already own a world.");
            return true;
        }

        WorldManager.createWorld(name);
        WorldRegistry.registerWorld(player.getName(), name, password);
        WorldManager.teleportToWorld(player, name);
        player.sendMessage("§aWorld created and joined!");
        return true;
    }
}