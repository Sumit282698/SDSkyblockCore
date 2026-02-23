package org.sumit282698.sDSkyblockCore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.sumit282698.sDSkyblockCore.objects.PlayerProfile;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

import java.util.ArrayList;
import java.util.List;

public class SkillsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        PlayerProfile profile = SDSkyblockCore.getProfileManager().getProfile(player.getUniqueId());

        Inventory gui = Bukkit.createInventory(null, 54, "Your Skyblock Stats");

        // Create a "Strength" icon
        ItemStack strengthItem = new ItemStack(Material.REDSTONE);
        ItemMeta meta = strengthItem.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Strength");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Current: " + ChatColor.RED + (int)profile.getStrength());
        meta.setLore(lore);
        strengthItem.setItemMeta(meta);

        gui.setItem(13, strengthItem); // Put it in the middle slot
        player.openInventory(gui);
        return true;
    }
}
