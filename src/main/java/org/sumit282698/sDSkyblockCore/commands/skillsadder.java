package org.sumit282698.sDSkyblockCore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;
import org.sumit282698.sDSkyblockCore.objects.PlayerProfile;

public class skillsadder implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Permission check
        if (!sender.hasPermission("skyblock.admin")) {
            sender.sendMessage("§cYou don't have permission to use this!");
            return true;
        }

        // Usage: /sdskills add <player> <stat> <amount>
        if (args.length < 4 || !args[0].equalsIgnoreCase("add")) {
            sender.sendMessage("§cUsage: /sdskills add <player> <mana|strength|defense> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("§cPlayer not found!");
            return true;
        }

        PlayerProfile profile = SDSkyblockCore.getProfileManager().getProfile(target.getUniqueId());
        String stat = args[2].toLowerCase();
        int amount;

        try {
            amount = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cAmount must be a number!");
            return true;
        }

        switch (stat) {
            case "mana":
            case "intelligence":
                profile.setMaxIntelligence(profile.getMaxIntelligence() + amount);
                profile.setIntelligence(profile.getMaxIntelligence()); // Refill mana on buff
                break;
            case "strength":
                profile.setStrength(profile.getStrength() + amount);
                break;
            case "defense":
                profile.setDefense(profile.getDefense() + amount);
                break;
            case "health":
                profile.setMaxHealth(profile.getMaxHealth() + amount);
                break;
            case "crit_damage":
                profile.setCritDamage(profile.getCritDamage() + amount);
                break;
            default:
                sender.sendMessage("§cInvalid stat! Use: mana, strength, or defense etc.");
                return true;
        }

        sender.sendMessage("§aAdded §6" + amount + " " + stat + " §ato §b" + target.getName());
        target.sendMessage("§aYour §6" + stat + " §awas increased by §b" + amount + "§a!");

        return true;
    }
}