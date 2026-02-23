package org.sumit282698.sDSkyblockCore.mannagers;

import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    // Stores items by a "key" name (e.g., "hyperion" -> ItemStack)
    private final Map<String, ItemStack> customItems = new HashMap<>();

    public void registerItem(String id, ItemStack item) {
        customItems.put(id.toLowerCase(), item);
    }

    public Map<String, ItemStack> getCustomItems() {
        return customItems;
    }
}
