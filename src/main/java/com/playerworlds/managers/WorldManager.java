package com.playerworlds.managers;

import org.bukkit.*;
import org.bukkit.entity.Player;

public class WorldManager {
    public static void createWorld(String name) {
        WorldCreator creator = new WorldCreator(name);
        creator.environment(World.Environment.NORMAL);
        creator.createWorld();
    }

    public static void loadWorld(String name) {
        Bukkit.createWorld(new WorldCreator(name));
    }

    public static void unloadWorld(String name) {
        World world = Bukkit.getWorld(name);
        if (world != null && world.getPlayers().isEmpty()) {
            Bukkit.unloadWorld(world, true);
        }
    }

    public static void teleportToWorld(Player player, String name) {
        World world = Bukkit.getWorld(name);
        if (world == null) loadWorld(name);
        player.teleport(Bukkit.getWorld(name).getSpawnLocation());
    }
}