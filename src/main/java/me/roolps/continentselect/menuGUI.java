package me.roolps.continentselect;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class menuGUI implements Listener {
    private static Inventory GUI;

    public void guiSetup(Player player){
        //creates empty inventory with no owner 9 big
        GUI = Bukkit.createInventory(null, 9, "CHOOSE A CONTINENT");

        //puts items in the inventory
        initializeMenu();
        player.openInventory(GUI);

    }

    //call whenever you want to put items into the inventory
    public void initializeMenu(){
        GUI.addItem(createGUItem(Material.DIAMOND, "ASIA"));
        GUI.addItem(createGUItem(Material.SNOWBALL, "africa"));
    }

    //customises names of the items
    protected ItemStack createGUItem(final Material material, final String name){
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        //set item meta
        meta.setDisplayName(name);

        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public static void onInventoryClick(final InventoryClickEvent event){
        if (event.getInventory() != GUI) return;
        event.setCancelled(true);

        final ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player player = (Player) event.getWhoClicked();
        new teleporterClass().teleport(player, clickedItem.getItemMeta().getDisplayName());
        new dataClass().onPlayerClick(player.getUniqueId(), clickedItem.getItemMeta().getDisplayName());
    }


}
