package net.sleepyspeller.dynamicallymotd;

import net.sleepyspeller.dynamicallymotd.events.EventPlayerPing;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DynamicallyMotd extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Booting up, hold tight...");

        // Init Events
        getServer().getPluginManager().registerEvents(new EventPlayerPing(this), this);

        // Init config
        saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Loaded successfully!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Shutting down...");
    }
}
