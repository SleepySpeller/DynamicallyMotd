package net.sleepyspeller.dynamicallymotd.command;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandMain implements CommandExecutor {
    private final DynamicallyMotd plugin;

    public CommandMain(DynamicallyMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!sender.hasPermission("dynamicallymotd.admin")){
            sender.sendMessage("No permission.");
            return true;
        }

        if(args.length == 0) {
            sender.sendMessage("[DynamicallyMotd] Up and running!");
        }

        return true;
    }
}
