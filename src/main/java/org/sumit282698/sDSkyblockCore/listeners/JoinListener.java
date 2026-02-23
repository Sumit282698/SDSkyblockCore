package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // This creates the stats for the player the second they join
        SDSkyblockCore.getProfileManager().createProfile(event.getPlayer().getUniqueId());
    }
}
