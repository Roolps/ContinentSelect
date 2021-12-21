package me.roolps.continentselect;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class dataClass implements Listener {
    private static File file;
    private static FileConfiguration dataFile;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev){
        System.out.println(ev.getPlayer().getUniqueId());
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ContinentSelect").getDataFolder() + "/playerdata/", ev.getPlayer().getUniqueId() + ".yml");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //exists but empty
            }
        }
        dataFile = YamlConfiguration.loadConfiguration(file);
        save(dataFile, file);
    }

    public static void save(FileConfiguration dataFile, File file){
        try{
            dataFile.save(file);
        }catch (IOException e){
            Bukkit.getConsoleSender().sendMessage("Unable to save File");
        }
    }

    //getter
    public static void get(UUID playerID){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ContinentSelect").getDataFolder() + "/playerdata/", playerID + ".yml");
        dataFile = YamlConfiguration.loadConfiguration(file);
        System.out.println(dataFile.get("Continent"));
        new teleporterClass().teleport(Bukkit.getPlayer(playerID), dataFile.get("Continent").toString());
    }

    public static void onPlayerClick(UUID playerID, String choice){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ContinentSelect").getDataFolder() + "/playerdata/", playerID + ".yml");
        dataFile = YamlConfiguration.loadConfiguration(file);
        dataFile.set("Continent", choice);
        save(dataFile, file);
    }

    public static void checkEmptyFile(UUID playerID){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ContinentSelect").getDataFolder() + "/playerdata/", playerID + ".yml");
        if (file.length()==0){
            new menuGUI().guiSetup(Bukkit.getPlayer(playerID));
        }else{
            get(playerID);
        }
    }
}
