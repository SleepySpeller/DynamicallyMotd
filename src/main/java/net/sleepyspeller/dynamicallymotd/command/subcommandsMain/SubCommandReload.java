package net.sleepyspeller.dynamicallymotd.command.subcommandsMain;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.libs.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

public class SubCommandReload extends SubCommand {
    public SubCommandReload(CommandSender sender, Command command, String s, String[] args, DynamicallyMotd plugin) {
        super(sender, command, s, args, plugin);
    }

    @Override
    public boolean run() {
        try{
            getPlugin().reloadConfigCustom();
        } catch (InvalidConfigurationException e) {
            getSender().sendMessage("Your config is not configured correctly! Please check your config.yml.");
            if (getArgs().length > 1 && "err".equals(getArgs()[1])) {
                getSender().sendMessage("Error code: " + e);
            }

            return true;
        }

        getSender().sendMessage("[DynamicallyMotd] Config reloaded successfully!");
        return true;
    }
}
