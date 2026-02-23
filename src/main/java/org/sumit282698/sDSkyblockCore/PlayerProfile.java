package org.sumit282698.sDSkyblockCore;

import java.util.UUID;

public class PlayerProfile {
    private final UUID uuid;
    private double health, maxHealth, defense, intelligence, maxIntelligence, strength;

    public PlayerProfile(UUID uuid) {
        this.uuid = uuid;
        this.health = 100;
        this.maxHealth = 100;
        this.defense = 0;
        this.intelligence = 100;
        this.maxIntelligence = 100;
        this.strength = 0;
    }

    // ADD THESE GETTERS (This fixes the red errors in ActionBar)
    public double getHealth() { return health; }
    public double getMaxHealth() { return maxHealth; }
    public double getDefense() { return defense; }
    public double getIntelligence() { return intelligence; }
    public double getMaxIntelligence() { return maxIntelligence; }
    public double getStrength() { return strength; }

    // This allows other classes to change your Mana/Intelligence
    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    // This allows other classes to change your Strength
    public void setStrength(double strength) {
        this.strength = strength;
    }

    // This allows other classes to change your Defense
    public void setDefense(double defense) {
        this.defense = defense;
    }
}