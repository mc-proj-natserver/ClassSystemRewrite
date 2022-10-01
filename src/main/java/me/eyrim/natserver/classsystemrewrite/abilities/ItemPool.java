package me.eyrim.natserver.classsystemrewrite.abilities;

import java.util.Hashtable;

public class ItemPool{
    private static final Hashtable<String, AbilityItem> ABILITY_ITEMS = new Hashtable<>();
    private static final Hashtable<String, PlayerClassItem> PLAYER_CLASS_ITEMS = new Hashtable<>();

    public static AbilityItem getAbilityItemFromAbilityName(String abilityName) {
        if (ABILITY_ITEMS.containsKey(abilityName)) {
            return ABILITY_ITEMS.get(abilityName);
        }

        throw new IllegalArgumentException();
    }

    private static void createAbilityItem(String itemName, int customModelData) {
        // TODO: 01/10/2022 Write when ItemBuilder is done
    }

    public static PlayerClassItem getPlayerClassItemFromPlayerClassName(String playerClassName) {
        if (PLAYER_CLASS_ITEMS.containsKey(playerClassName)) {
            return PLAYER_CLASS_ITEMS.get(playerClassName);
        }

        throw new IllegalArgumentException();
    }

    private static void createPlayerClassItem(String playerClassName, int customModelData) {
        // TODO: 01/10/2022 Write when ItemBuilder is done
    }
}
