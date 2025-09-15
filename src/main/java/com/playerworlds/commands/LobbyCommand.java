package com.playerworlds.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        player.sendMessage("§aReturned to lobby.");
        return true;
    }
}