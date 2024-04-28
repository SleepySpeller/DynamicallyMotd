package net.sleepyspeller.dynamicallymotd.libs;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class SubCommand {
    private final CommandSender sender;
    private final Command command;
    private final String s;
    private final String[] args;
    private final DynamicallyMotd plugin;

    public SubCommand(CommandSender sender, Command command, String s, String[] args, DynamicallyMotd plugin) {
        this.sender = sender;
        this.command = command;
        this.s = s;
        this.args = args;
        this.plugin = plugin;
    }

    public CommandSender getSender() {
        return sender;
    }

    public Command getCommand() {
        return command;
    }

    public String getS() {
        return s;
    }

    public String[] getArgs() {
        return args;
    }
    public DynamicallyMotd getPlugin() {
        return plugin;
    }

    public abstract boolean run();
}
