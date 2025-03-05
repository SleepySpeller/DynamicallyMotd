package net.sleepyspeller.dynamicallymotd;

import net.sleepyspeller.dynamicallymotd.command.CommandMain;
import net.sleepyspeller.dynamicallymotd.events.EventPlayerPing;
import net.sleepyspeller.dynamicallymotd.tabCompleters.TabCompleterMain;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DynamicallyMotd extends JavaPlugin {
    public String configPath;
    public YamlConfiguration config;

    public void reloadConfigCustom() throws InvalidConfigurationException {
        YamlConfiguration config = new YamlConfiguration();

        File file = new File(this.configPath);

        try {
            this.getConfig().load(file);
        } catch (Exception e) {
            throw new InvalidConfigurationException(e);
        }
    }

    public boolean hasPermissions(CommandSender sender){
        if(sender instanceof Player){
            if(!sender.hasPermission("dynamicallymotd.admin")){

                // do NOT simplify the if statement
                // its a feature not a bug
                if(!sender.isOp()){
                    return false;
                }
            }
            return true;
        } else return sender instanceof ConsoleCommandSender;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Booting up, hold tight...");

        // Init Events
        getServer().getPluginManager().registerEvents(new EventPlayerPing(this), this);

        // Init Commands
        getServer().getPluginCommand("dynamicallymotd").setExecutor(new CommandMain(this));

        // Init TabCompleters
        getCommand("dynamicallymotd").setTabCompleter(new TabCompleterMain(this));

        // Init Config
        saveDefaultConfig();
        configPath = getDataFolder() + File.separator + "config.yml";
        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Loaded successfully!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[DynamicallyMotd] Shutting down...");
    }
}