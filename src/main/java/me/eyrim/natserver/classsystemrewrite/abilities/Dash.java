package me.eyrim.natserver.classsystemrewrite.abilities;

import org.bukkit.entity.Player;

public class Dash implements Ability {
    private final String ABILITY_NAME = "Dash";
    private final int MODEL_DATA = 1234;
    private final AbilityItem ITEM = ItemPool.getAbilityItemFromAbilityName(ABILITY_NAME);

    @Override
    public String getAbilityName() {
        return this.ABILITY_NAME;
    }

    @Override
    public AbilityItem getAbilityItem() {
        return this.ITEM;
    }

    @Override
    public void activate(Player player) {
        // TODO: 01/10/2022 Write ability (can copy code from previous)
    }
}
