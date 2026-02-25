package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Change this to use your new load method
        SDSkyblockCore.getProfileManager().loadProfile(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // Save their hard-earned stats!
        SDSkyblockCore.getProfileManager().saveProfile(event.getPlayer().getUniqueId());
    }
}
