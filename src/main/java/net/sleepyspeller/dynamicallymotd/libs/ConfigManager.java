package net.sleepyspeller.dynamicallymotd.libs;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private DynamicallyMotd plugin = DynamicallyMotd.getPlugin(DynamicallyMotd.class);

    public static FileConfiguration playerscfg;
    public static File playersfile;

    public void setup(){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

        playerscfg.setDefaults(plugin.getConfig().getDefaults());
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);

        Bukkit.getServer().getConsoleSender().sendMessage("Players.yml file has been loaded successfully!");
    }

    public FileConfiguration getConfig(){
        return playerscfg;
    }

    public static void saveConfig(){
        try{
            playerscfg.save(playersfile);
        }catch(IOException e){
            Bukkit.getServer().getConsoleSender().sendMessage("[AOMEI] Could not create the players.yml file");
        }
    }

    public static void reloadConfig(){
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    }


//    public static void saveInfectedPlayer(Player player){
//        Bukkit.getServer().getConsoleSender().sendMessage("[ThreadGames] Trying to save the infected player!");
//        String playerName = player.getName();
//
//        ItemStack headItem = player.getInventory().getHelmet();
//
//        //ItemStack stack = new ItemStack(headItem.getType());
//
//        if(headItem == null){
//            playerscfg.set(playerName + ".HeadItem", "none");
//            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[AOMEI] The player isn't wearing an hat");
//        }else{
//            playerscfg.set(playerName + ".HeadItem", headItem);
//        }
//
//
//        savePlayers();
//        reloadPlayers();
//    }
}
