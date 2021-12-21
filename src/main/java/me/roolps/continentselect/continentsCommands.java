package me.roolps.continentselect;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class continentsCommands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        new dataClass().checkEmptyFile(((Player) sender).getUniqueId());
        return true;
    }
}