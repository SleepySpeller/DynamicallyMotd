package net.sleepyspeller.dynamicallymotd.events;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.libs.ConfMgr;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class EventPlayerPing implements Listener {
    private final DynamicallyMotd plugin;
    public EventPlayerPing(DynamicallyMotd plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPing(ServerListPingEvent event) {
        ConfMgr config = new ConfMgr(plugin);
        event.setMotd(config.getMotdRandom());
    }
}
