package me.eyrim.natserver.classsystemrewrite.abilities;

import org.bukkit.entity.Player;

/**
 * Interface which all Ability classes must implement
 */
public interface Ability {
    /**
     * @return The ability name as a String
     */
    public String getAbilityName();
    /**
     * @return The AbilityItem of this ability
     */
    public AbilityItem getAbilityItem();
    /**
     * Activates the ability associated with this class
     * @param player The player the ability is being activated on
     */
    public void activate(Player player);
}
