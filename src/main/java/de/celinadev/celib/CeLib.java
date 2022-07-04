package de.celinadev.celib;

import org.bukkit.plugin.java.JavaPlugin;

public class CeLib {

    private JavaPlugin plugin;
    private static CeLib instance;

    public CeLib(JavaPlugin plugin) {
        this.plugin = plugin;
        instance = this;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public static CeLib getInstance() {
        return instance;
    }
}
