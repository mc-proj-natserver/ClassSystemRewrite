package me.eyrim.natserver.classsystemrewrite.abilities.items;

import me.eyrim.natserver.classsystemrewrite.abilities.util.AbilityPool;
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
        AbilityPool.getAbilityFromName(this._AbilityName).activate(player);
    }
}
