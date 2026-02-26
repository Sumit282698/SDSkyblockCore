package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();

        if (title.equals("Your Skyblock Stats")) {
            event.setCancelled(true);
        }
        else if (title.equals("Item Browser")) {
            event.setCancelled(true); // Don't let them move the item
            if (event.getCurrentItem() != null) {
                // Give the player a copy of the item they clicked
                event.getWhoClicked().getInventory().addItem(event.getCurrentItem().clone());
                event.getWhoClicked().sendMessage("§eYou took an item from the browser!");
            }
        }
    }
}
