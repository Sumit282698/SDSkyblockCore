package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.sumit282698.sDSkyblockCore.objects.PlayerProfile;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

public class AbilityListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            // Check if holding the AOTE (You can refine this with NBT later!)
            if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD ||
                    player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Aspect of the End")) {

                PlayerProfile profile = SDSkyblockCore.getProfileManager().getProfile(player.getUniqueId());

                if (profile.getIntelligence() >= 50) {
                    profile.setIntelligence(profile.getIntelligence() - 50);

                    // Simple teleport 8 blocks forward
                    player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(8)));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                    player.sendMessage(ChatColor.AQUA + "-50 Mana (" + ChatColor.GOLD + "Instant Transmission" + ChatColor.AQUA + ")");
                } else {
                    player.sendMessage(ChatColor.RED + "Not enough Mana!");
                }
            }
        }
    }
}