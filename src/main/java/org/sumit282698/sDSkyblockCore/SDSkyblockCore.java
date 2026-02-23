package org.sumit282698.sDSkyblockCore;

import org.bukkit.plugin.java.JavaPlugin;
import org.sumit282698.sDSkyblockCore.commands.Items;
import org.sumit282698.sDSkyblockCore.commands.SkillsCommand;
import org.sumit282698.sDSkyblockCore.listeners.AbilityListener;
import org.sumit282698.sDSkyblockCore.listeners.JoinListener;
import org.sumit282698.sDSkyblockCore.mannagers.ItemManager;
import org.sumit282698.sDSkyblockCore.mannagers.ProfileManager;
import org.sumit282698.sDSkyblockCore.tasks.ActionBar;

public final class SDSkyblockCore extends JavaPlugin {
    private static ProfileManager profileManager;
    private static ItemManager itemManager;
    @Override
    public void onEnable() {
        //Commands
        getCommand("sdstats").setExecutor(new SkillsCommand());

        //Events
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);

        //idk why but whats it is
        profileManager = new ProfileManager();
        itemManager = new ItemManager();

        //tasks
        getCommand("sbadmin").setExecutor(new Items());
        new ActionBar().runTaskTimer(this, 0L, 2L);
        //My Start Message
        getLogger().info("SDSkyblock Core Started XD");
    }
    public static ProfileManager getProfileManager() {
        return profileManager;
    }
    public static ItemManager getItemManager() {
        return itemManager;
    }

    @Override
    public void onDisable() {
        getLogger().info("SDSkyBlock Core shutting down...");
    }
} 
