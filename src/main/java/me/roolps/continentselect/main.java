package me.roolps.continentselect;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class main extends JavaPlugin {

    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin started up succesfully");

        //register continents command
        this.getCommand("continents").setExecutor(new continentsCommands());

        //register two events - on join and inventory click
        getServer().getPluginManager().registerEvents(new menuGUI(), this);
        getServer().getPluginManager().registerEvents(new dataClass(), this);

        //creates playerdata directory if not already there
        File file = new File(this.getDataFolder() + "/playerdata");
        if(!file.exists()) {
            file.mkdir();
        }
    }

    public void onDisable() {
        // Plugin shutdown logic
    }
}
