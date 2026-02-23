package org.sumit282698.sDSkyblockCore.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

import java.util.ArrayList;
import java.util.List;

public class Items implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("skyblock.admin")) {
            player.sendMessage("§cYou don't have permission!");
            return true;
        }

        // Usage: /sbadmin create <id> <strength> <defense>
        if (args.length >= 4 && args[0].equalsIgnoreCase("create")) {
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.AIR) return true;

            String id = args[1];
            int strength = Integer.parseInt(args[2]);
            int defense = Integer.parseInt(args[3]);

            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + id.replace("_", " "));

            List<String> lore = new ArrayList<>();
            lore.add("§7Strength: §c+" + strength);
            lore.add("§7Defense: §a+" + defense);
            meta.setLore(lore);

            item.setItemMeta(meta);

            // Save to our manager
            SDSkyblockCore.getItemManager().registerItem(id, item.clone());
            player.sendMessage("§aItem '" + id + "' created and saved!");
            return true;
        }

        // Command to open the Browser Menu
        if (args.length == 1 && args[0].equalsIgnoreCase("menu")) {
            openItemBrowser(player);
            return true;
        }

        return false;
    }

    private void openItemBrowser(Player player) {
        org.bukkit.inventory.Inventory inv = org.bukkit.Bukkit.createInventory(null, 54, "Admin Item Browser");
        for (ItemStack item : SDSkyblockCore.getItemManager().getCustomItems().values()) {
            inv.addItem(item);
        }
        player.openInventory(inv);
    }
}
