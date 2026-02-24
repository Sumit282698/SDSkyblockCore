package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();

        if (title.equals("Skyblock Profile")) {
            event.setCancelled(true);
        }
        else if (title.equals("Admin Item Browser")) {
            event.setCancelled(true); // Don't let them move the item
            if (event.getCurrentItem() != null) {
                // Give the player a copy of the item they clicked
                event.getWhoClicked().getInventory().addItem(event.getCurrentItem().clone());
                event.getWhoClicked().sendMessage("§eYou took an item from the browser!");
            }
        }
    }
}
