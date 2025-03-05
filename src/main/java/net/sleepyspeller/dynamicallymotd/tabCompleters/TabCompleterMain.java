package net.sleepyspeller.dynamicallymotd.tabCompleters;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TabCompleterMain implements TabCompleter {
    private final DynamicallyMotd plugin;
    private final String[] fillers = {"add", "reload", "list"};

    public TabCompleterMain(DynamicallyMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("dynamicallymotd") && args.length == 1 && plugin.hasPermissions(sender)) {
            return List.of(fillers);
        }

        return null;
    }
}
