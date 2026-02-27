package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.sumit282698.sDSkyblockCore.api.PlayerSkills;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

import java.util.UUID;

public class PlayerConnectionListener implements Listener {

    private final SDSkyblockCore plugin;

    public PlayerConnectionListener(SDSkyblockCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        // 1. Create the blank profile in memory
        plugin.getProfileManager().createProfile(uuid);
        PlayerSkills PlayerSkills = plugin.getProfileManager().getProfile(uuid);

        // 2. Load the actual data from SQLite into the SPlayer object
        plugin.getDatabase().loadSPlayer(PlayerSkills);

        // 3. Sync the Health (Pro Fix)
        // Unlock the Minecraft health cap so 100+ health works
        player.getAttribute(Attribute.MAX_HEALTH)
                .setBaseValue(PlayerSkills.getMaxHealth());
        player.setHealth(PlayerSkills.getMaxHealth()); // Set to full health on join

        player.sendMessage("§a§lSKYBLOCK §7Stats loaded successfully!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        PlayerSkills PlayerSkills = plugin.getProfileManager().getProfile(uuid);

        if (PlayerSkills != null) {
            // Save to database before removing from memory
            plugin.getDatabase().saveSPlayer(PlayerSkills);
            plugin.getProfileManager().removeProfile(uuid);
        }
    }
}