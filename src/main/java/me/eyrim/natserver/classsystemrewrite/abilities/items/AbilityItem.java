package me.eyrim.natserver.classsystemrewrite.abilities.items;

import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItemPool;
import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AbilityItem extends ItemStack {
    private final String _AbilityName;

    public AbilityItem(String abilityName, Material material, int count) {
        super(material, count);

        this._AbilityName = abilityName;
    }

    public String getAbilityName() {
        return this._AbilityName;
    }

    public void activateAbility(Player player) {
        AbilityItemPool.getItem(this._AbilityName).activateAbility(player);
    }

    public Ability getAbility() {

    }
}
