package net.sleepyspeller.dynamicallymotd.command;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.command.subcommandsMain.SubCommandAdd;
import net.sleepyspeller.dynamicallymotd.command.subcommandsMain.SubCommandList;
import net.sleepyspeller.dynamicallymotd.command.subcommandsMain.SubCommandReload;
import net.sleepyspeller.dynamicallymotd.libs.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandMain implements CommandExecutor {
    private final DynamicallyMotd plugin;
    private final String defaultMessage = "[DynamicallyMotd] Up and running! Ver 1.1";

    public CommandMain(DynamicallyMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!plugin.hasPermissions(sender)){
            sender.sendMessage("No permission.");
            return true;
        }

        if(args.length == 0) {
            sender.sendMessage(defaultMessage);
            return true;
        }

        switch (args[0]){
            case "add":
                SubCommand subAdd = new SubCommandAdd(sender, command, s, args, plugin);
                return subAdd.run();

            case "reload":
                SubCommand subReload = new SubCommandReload(sender, command, s, args, plugin);
                return subReload.run();

            case "list":
                SubCommand subList = new SubCommandList(sender, command, s, args, plugin);
                return subList.run();

            default:
                sender.sendMessage(defaultMessage);
                return true;
        }
    }
}
