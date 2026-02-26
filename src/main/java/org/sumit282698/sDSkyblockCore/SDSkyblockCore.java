package org.sumit282698.sDSkyblockCore;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.sumit282698.sDSkyblockCore.commands.Items;
import org.sumit282698.sDSkyblockCore.commands.skills;
import org.sumit282698.sDSkyblockCore.commands.skillsadder;
import org.sumit282698.sDSkyblockCore.listeners.AbilityListener;
import org.sumit282698.sDSkyblockCore.listeners.JoinListener;
import org.sumit282698.sDSkyblockCore.mannagers.ItemManager;
import org.sumit282698.sDSkyblockCore.mannagers.ProfileManager;
import org.sumit282698.sDSkyblockCore.tasks.ActionBar;
import org.sumit282698.sDSkyblockCore.listeners.MenuListener;

public final class SDSkyblockCore extends JavaPlugin {
    private static ProfileManager profileManager;
    private static ItemManager itemManager;
    private static SDSkyblockCore instance;


    @Override
    public void onEnable() {
        //Commands
        instance = this;
        getCommand("sdstats").setExecutor(new skills());
        getCommand("sditems").setExecutor(new Items());
        getCommand("sdskills").setExecutor(new skillsadder());

        //Events
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        //idk why but what it is, it is
        profileManager = new ProfileManager();
        itemManager = new ItemManager();

        //tasks
        new ActionBar().runTaskTimer(this, 0L, 2L);
        //My Start Message
        getLogger().info("SDSkyblock Core Started XD");
    }
    public static SDSkyblockCore getInstance() {
        return instance;
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
