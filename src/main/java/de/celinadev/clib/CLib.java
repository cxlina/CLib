package de.celinadev.clib;

import org.bukkit.plugin.java.JavaPlugin;

public class CLib {

    private JavaPlugin plugin;
    private static CLib instance;

    public CLib(JavaPlugin plugin) {
        this.plugin = plugin;
        instance = this;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public static CLib getInstance() {
        return instance;
    }
}
