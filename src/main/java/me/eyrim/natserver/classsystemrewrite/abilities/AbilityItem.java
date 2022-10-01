package me.eyrim.natserver.classsystemrewrite.abilities;

import org.bukkit.inventory.ItemStack;

public class AbilityItem extends ItemStack {
    private final Ability ABILITY;

    public AbilityItem(Ability ability) {
        this.ABILITY = ability;
    }

    public Ability getAbility() {
        return this.ABILITY;
    }
}
