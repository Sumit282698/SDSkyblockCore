package org.sumit282698.sDSkyblockCore;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerProfile profile = SDSkyblockCore.getProfileManager().getProfile(player.getUniqueId());

            if (profile != null) {
                // ActionBar Message Every Second XD
                if (profile.getIntelligence() < profile.getMaxIntelligence()) {
                    double regenAmount = profile.getMaxIntelligence() * 0.02 / 5; // Adjust speed here
                    profile.setIntelligence(Math.min(profile.getMaxIntelligence(), profile.getIntelligence() + regenAmount));
                }

                String health = ChatColor.RED + "" + (int)profile.getHealth() + "/" + (int)profile.getMaxHealth() + "❤ Health";
                String defense = ChatColor.GREEN + "" + (int)profile.getDefense() + "❈ Defense";
                String mana = ChatColor.AQUA + "" + (int)profile.getIntelligence() + "/" + (int)profile.getMaxIntelligence() + "✎ Mana";

                String message = health + "    " + defense + "    " + mana;

                // Sending the message to the Action Bar
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
            }
        }
    }
}
