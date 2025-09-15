package com.playerworlds.storage;

import com.playerworlds.PlayerWorlds;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WorldRegistry {
    private static Map<String, WorldData> registry = new HashMap<>();
    private static final File file = new File(PlayerWorlds.getInstance().getDataFolder(), "worlds.yml");

    public static void loadRegistry() {
        if (!file.exists()) return;

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        for (String player : config.getKeys(false)) {
            String name = config.getString(player + ".name");
            String password = config.getString(player + ".password");
            if (name != null && password != null) {
                registry.put(player, new WorldData(name, password));
            }
        }
    }

    public static void saveRegistry() {
        YamlConfiguration config = new YamlConfiguration();
        for (Map.Entry<String, WorldData> entry : registry.entrySet()) {
            String player = entry.getKey();
            WorldData data = entry.getValue();
            config.set(player + ".name", data.name);
            config.set(player + ".password", data.password);
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerWorld(String player, String name, String password) {
        if (registry.containsKey(player)) return false;
        registry.put(player, new WorldData(name, password));
        saveRegistry(); // Save immediately
        return true;
    }

    public static WorldData getWorldData(String name) {
        return registry.values().stream()
            .filter(data -> data.name.equals(name))
            .findFirst().orElse(null);
    }

    public static boolean ownsWorld(String player) {
        return registry.containsKey(player);
    }

    public static class WorldData {
        public String name;
        public String password;
        public WorldData(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }
}