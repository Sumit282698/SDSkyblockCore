package org.sumit282698.sDSkyblockCore.managers;

import org.sumit282698.sDSkyblockCore.api.PlayerSkills;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {
    // This Map holds all online players and their stats
    private final Map<UUID, PlayerSkills> profiles = new HashMap<>();

    //Creating New ID in Memory For First JOIN .
    public void createProfile(UUID uuid) {
        if (!profiles.containsKey(uuid)) {
            profiles.put(uuid, new PlayerSkills(uuid));
        }
    }

    // Getting Player Memory
    public PlayerSkills getProfile(UUID uuid) {
        return profiles.get(uuid);
    }
    // Memry UUID REMOVER
    public void removeProfile(UUID uuid) {
        profiles.remove(uuid);
    }

    public Map<UUID, PlayerSkills> getProfiles() {
        return profiles;
    }
}
