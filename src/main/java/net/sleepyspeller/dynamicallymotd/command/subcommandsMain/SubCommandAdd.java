package net.sleepyspeller.dynamicallymotd.command.subcommandsMain;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.libs.ConfMgr;
import net.sleepyspeller.dynamicallymotd.libs.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class SubCommandAdd extends SubCommand {
    public SubCommandAdd(CommandSender sender, Command command, String s, String[] args, DynamicallyMotd plugin) {
        super(sender, command, s, args, plugin);
    }

    @Override
    public boolean run() {
        ConfMgr config = new ConfMgr(getPlugin());

        if(getArgs().length <= 1) {
            getSender().sendMessage("[DynamicallyMotd] No new motd specified!");
            return true;
        }

        String[] newArgs = Arrays.copyOfRange(getArgs(), 1, getArgs().length);
        String newMotd = "";

        for(String item : newArgs) {
            newMotd = newMotd + item + " ";
        }

        config.addMotd(newMotd);

        getSender().sendMessage("[DynamicallyMotd] Successfully added your motd to the list!");
        getPlugin().saveConfig();
        return true;
    }
}
