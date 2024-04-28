package net.sleepyspeller.dynamicallymotd.command.subcommandsMain;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.libs.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SubCommandReload extends SubCommand {
    public SubCommandReload(CommandSender sender, Command command, String s, String[] args, DynamicallyMotd plugin) {
        super(sender, command, s, args, plugin);
    }

    @Override
    public boolean run() {
        getPlugin().reloadConfig();
        getSender().sendMessage("[DynamicallyMotd] Config reloaded successfully!");
        return true;
    }
}
