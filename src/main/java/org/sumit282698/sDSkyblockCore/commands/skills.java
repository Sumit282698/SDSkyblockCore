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

public class skills implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        PlayerProfile profile = SDSkyblockCore.getProfileManager().getProfile(player.getUniqueId());

        Inventory gui = Bukkit.createInventory(null, 54, "Your Skyblock Stats");

        // Combat Stats
        ItemStack combat_stats = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = combat_stats.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Combat Stats");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Gives you a better chance at");
        lore.add(ChatColor.GRAY + "fighting strong monsters");
        lore.add(ChatColor.GRAY + " ");
        lore.add(ChatColor.RED + "Health " + ChatColor.WHITE + (int)profile.getMaxHealth());
        lore.add(ChatColor.GREEN + "Defence " + ChatColor.WHITE + (int)profile.getDefense());
        lore.add(ChatColor.RED + "Strength " + ChatColor.WHITE + (int)profile.getStrength());
        lore.add(ChatColor.AQUA + "Intelligence " + ChatColor.WHITE + (int)profile.getMaxIntelligence());
        lore.add(ChatColor.DARK_BLUE + "Crit Chance " + ChatColor.WHITE + "0");
        lore.add(ChatColor.DARK_BLUE + "Crit Damage " + ChatColor.WHITE + "0");
        lore.add(ChatColor.GOLD + "Bonus Attack Speed " + ChatColor.WHITE + "0");
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        lore.add(ChatColor.GRAY + "soon " );
        meta.setLore(lore);
        combat_stats.setItemMeta(meta);

        // Gathering Stats
        ItemStack gathering_stats = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta_1 = gathering_stats.getItemMeta();
        meta_1.setDisplayName(ChatColor.GREEN + "Gathering Stats");
        List<String> lore_1 = new ArrayList<>();
        lore_1.add(ChatColor.GRAY + "Current: ");
        meta_1.setLore(lore_1);
        gathering_stats.setItemMeta(meta_1);

        // Misc Stats
        ItemStack misc_stats = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta2 = misc_stats.getItemMeta();
        meta2.setDisplayName(ChatColor.LIGHT_PURPLE + "Misc Stats");
        List<String> lore2 = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Current: " + ChatColor.RED + (int)profile.getStrength());
        meta2.setLore(lore2);
        misc_stats.setItemMeta(meta2);


        // Item Location
        gui.setItem(15, combat_stats);
        gui.setItem(16, gathering_stats);
        gui.setItem(24, misc_stats);
        player.openInventory(gui);
        return true;
    }
}
