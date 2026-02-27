package org.sumit282698.sDSkyblockCore.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;
import org.sumit282698.sDSkyblockCore.api.PlayerSkills;


public class CombatListener implements Listener {
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;

        PlayerSkills sPlayer = SDSkyblockCore.getSPlayer(player.getUniqueId());
        ItemStack weapon = player.getInventory().getItemInMainHand();

        // 1. Get Weapon Base Damage
        double baseDamage = 0;
        if (weapon.hasItemMeta()) {
            baseDamage = weapon.getItemMeta().getPersistentDataContainer()
                    .getOrDefault(new NamespacedKey(SDSkyblockCore.getInstance(), "damage"), PersistentDataType.DOUBLE, 0.0);
        }

        // 2. The Formula
        double strength = sPlayer.getStrength(); // Add bonusStrength here too!
        double critDamage = sPlayer.getCritDamage();

        double damage = (5 + baseDamage) * (1 + (strength / 100.0));

        // 3. Roll for Crit
        boolean isCrit = Math.random() * 100 < sPlayer.getCritChance();
        if (isCrit) {
            damage *= (1 + (critDamage / 100.0));
            player.sendMessage("§c✧ " + (int)damage + " ✧"); // Crit indicator
        }

        event.setDamage(damage / 5.0); // Minecraft health is small, so we scale it down
    }
}
