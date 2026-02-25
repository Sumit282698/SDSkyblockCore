package org.sumit282698.sDSkyblockCore.mannagers;

import org.bukkit.configuration.file.FileConfiguration;
import org.sumit282698.sDSkyblockCore.SDSkyblockCore;
import org.sumit282698.sDSkyblockCore.objects.PlayerProfile;

import java.util.HashMap;
import java.util.UUID;

public class ProfileManager {
    private final HashMap<UUID, PlayerProfile> profiles = new HashMap<>();

    public void createProfile(UUID uuid) {
        profiles.put(uuid, new PlayerProfile(uuid));
    }

    public PlayerProfile getProfile(UUID uuid) {
        return profiles.get(uuid);
    }

    public void removeProfile(UUID uuid) {
        profiles.remove(uuid);
    }


    public void saveProfile(UUID uuid) {
        PlayerProfile profile = profiles.get(uuid);
        if (profile == null) return;

        FileConfiguration config = SDSkyblockCore.getInstance().getConfig();
        String path = "players." + uuid.toString() + ".";

        config.set(path + "strength", profile.getStrength());
        config.set(path + "defense", profile.getDefense());
        config.set(path + "mana", profile.getMaxIntelligence());
        // Add health, crit, etc. here

        SDSkyblockCore.getInstance().saveConfig();
    }

    // Update your getProfile or createProfile to LOAD the data
    public PlayerProfile loadProfile(UUID uuid) {
        FileConfiguration config = SDSkyblockCore.getInstance().getConfig();
        if (!config.contains("players." + uuid.toString())) {
            return new PlayerProfile(uuid); // New player gets default stats
        }

        String path = "players." + uuid.toString() + ".";
        PlayerProfile profile = new PlayerProfile(uuid);
        profile.setStrength(config.getDouble(path + "strength"));
        profile.setDefense(config.getDouble(path + "defense"));
        // Load the rest...

        profiles.put(uuid, profile);
        return profile;
    }
}
