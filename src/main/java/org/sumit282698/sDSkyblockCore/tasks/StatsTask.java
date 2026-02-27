package org.sumit282698.sDSkyblockCore.tasks;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.sumit282698.sDSkyblockCore.api.PlayerSkills;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

public class StatsTask extends BukkitRunnable {

    private final SDSkyblockCore plugin;

    public StatsTask(SDSkyblockCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerSkills sPlayer = plugin.getProfileManager().getProfile(player.getUniqueId());
            if (sPlayer == null) continue;

            // 1. Mana Regeneration (Example: 2% of Max Mana per second)
            if (sPlayer.getCurrentMana() < sPlayer.getMaxMana()) {
                sPlayer.setCurrentMana(Math.min(sPlayer.getMaxMana(), sPlayer.getCurrentMana() + (sPlayer.getMaxMana() * 0.02)));
            }

            // 2. Build the Bar String
            // Format: 500/500❤     100❈ Defense    100/100✎ Mana
            String healthStr = "§c" + (int) sPlayer.getCurrentHealth() + "/" + (int) sPlayer.getMaxHealth() + "❤";
            String defenseStr = "§a" + (int) sPlayer.getDefense() + "❈ Defense";
            String manaStr = "§b" + (int) sPlayer.getCurrentMana() + "/" + (int) sPlayer.getMaxMana() + "✎ Mana";

            String actionBar = healthStr + "     " + defenseStr + "     " + manaStr;

            // 3. Send to Player
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBar));

            // 4. Keep Minecraft Hearts in sync
            double ratio = sPlayer.getCurrentHealth() / sPlayer.getMaxHealth();
            player.setHealth(Math.max(0, Math.min(20.0, ratio * 20.0)));
        }
    }
}
