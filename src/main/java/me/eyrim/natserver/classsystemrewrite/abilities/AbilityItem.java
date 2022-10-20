package me.eyrim.natserver.classsystemrewrite.abilities;

import org.bukkit.inventory.ItemStack;

/**
 * Represents an ability item. This is an item which allows the activation of abilities. <br\><br\>
 * This class extends ItemStack and is used in place of a basic ItemStack when given to the player.
 */
public class AbilityItem extends ItemStack {
    /**
     * The ability corresponding to this item
     */
    private final Ability ABILITY;

    /**
     * Creates a new AbilityItem object
     * @param ability The ability corresponding to the Minecraft item
     */
    public AbilityItem(Ability ability) {
        this.ABILITY = ability;
    }

    /**
     * @return The ability corresponding to this item
     */
    public Ability getAbility() {
        return this.ABILITY;
    }
}
