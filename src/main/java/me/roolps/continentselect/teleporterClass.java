package me.roolps.continentselect;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class teleporterClass {
    public void teleport(Player player, String choice){
        if (choice=="ASIA"){
            Location loc = new Location(Bukkit.getWorld("World"), 10, 100, 16, 0, 0);
            player.teleport(loc);
        }else if (choice=="africa"){
            Location loc = new Location(Bukkit.getWorld("world_nether"), 10, 100, 16, 0, 0);
            player.teleport(loc);
        }
    }
}
