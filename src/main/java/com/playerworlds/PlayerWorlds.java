package com.playerworlds;

import com.playerworlds.commands.*;
import com.playerworlds.storage.WorldRegistry;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerWorlds extends JavaPlugin {
    private static PlayerWorlds instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("createworld").setExecutor(new CreateWorldCommand());
        getCommand("joinworld").setExecutor(new JoinWorldCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());
        WorldRegistry.loadRegistry();
        startAutoUnloadTask();
    }

    @Override
    public void onDisable() {
        WorldRegistry.saveRegistry();
    }

    public static PlayerWorlds getInstance() {
        return instance;
    }

    private void startAutoUnloadTask() {
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            for (World world : Bukkit.getWorlds()) {
                String name = world.getName();
                if (!name.equals("world") && world.getPlayers().isEmpty()) {
                    Bukkit.unloadWorld(world, true);
                    getLogger().info("Unloaded world: " + name);
                }
            }
        }, 20 * 60, 20 * 60); // every 60 seconds
    }
}