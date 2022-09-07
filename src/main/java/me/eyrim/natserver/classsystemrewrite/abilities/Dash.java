package me.eyrim.natserver.classsystemrewrite.abilities;

import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItem;
import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItemManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dash implements Ability {
    private final String _ABILITY_NAME = "Dash";
    private final int _MODEL_DATA = 1234;
    private final AbilityItem _ITEM = AbilityItemManager.createItem(_ABILITY_NAME, _MODEL_DATA);

    @Override
    public String getAbilityName() {
        return _ABILITY_NAME;
    }

    @Override
    public int getModelData() {
        return _MODEL_DATA;
    }

    @Override
    public ItemStack getItem() {
        return _ITEM;
    }

    @Override
    public void activate(Player player) {
        // Adds the vector of the eye to the vector of the player movement, this can be tuned with a blanket multiplication to the vector
        player.setVelocity(player.getEyeLocation().getDirection().add(player.getVelocity()));
    }
}
