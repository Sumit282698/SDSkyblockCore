package org.sumit282698.sDSkyblockCore.mannagers;

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
}
