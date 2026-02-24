package org.sumit282698.sDSkyblockCore.objects;

import java.util.UUID;

public class PlayerProfile {
    private final UUID uuid;
    private double health, maxHealth, defense, intelligence, maxIntelligence, strength, critChance, critDamage;

    public PlayerProfile(UUID uuid) {
        this.uuid = uuid;
        this.health = 100;
        this.maxHealth = 100;
        this.defense = 0;
        this.intelligence = 100;
        this.maxIntelligence = 100;
        this.strength = 0;
        this.critChance = 0.0;
        this.critDamage = 0;
    }

    // Getting DAta
    public double getHealth() { return health; }
    public double getMaxHealth() { return maxHealth; }
    public double getDefense() { return defense; }
    public double getIntelligence() { return intelligence; }
    public double getMaxIntelligence() { return maxIntelligence; }
    public double getStrength() { return strength; }
    public double getCritChance() { return critChance; }
    public double getCritDamage() { return critDamage; }

// Setting Data
    public void setMaxHealth(double maxHealth) { this.maxHealth = maxHealth; }
    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }
    public void setCritChance(double critChance) { this.critChance = critChance; }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public void setCritDamage(double critDamage) { this.critDamage = critDamage; }
    public void setDefense(double defense) {
        this.defense = defense;
    }
    public void setMaxIntelligence(double maxIntelligence) {
        this.maxIntelligence = maxIntelligence;
    }
}