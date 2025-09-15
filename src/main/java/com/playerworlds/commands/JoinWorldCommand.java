package com.playerworlds.commands;

import com.playerworlds.managers.WorldManager;
import com.playerworlds.storage.WorldRegistry;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class JoinWorldCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) || args.length != 2) return false;
        Player player = (Player) sender;
        String name = args[0], password = args[1];

        WorldRegistry.WorldData data = WorldRegistry.getWorldData(name);
        if (data == null || !data.password.equals(password)) {
            player.sendMessage("§cInvalid world or password.");
            return true;
        }

        WorldManager.teleportToWorld(player, name);
        player.sendMessage("§aJoined world: " + name);
        return true;
    }
}