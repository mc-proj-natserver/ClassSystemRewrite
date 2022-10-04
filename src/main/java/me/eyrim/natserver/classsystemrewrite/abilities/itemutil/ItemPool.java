package me.eyrim.natserver.classsystemrewrite.abilities.itemutil;

import me.eyrim.natserver.classsystemrewrite.abilities.AbilityItem;
import org.bukkit.inventory.ItemStack;

import java.util.Hashtable;

public class ItemPool {
    private static final Hashtable<String, AbilityItem> ABILITY_ITEMS = new Hashtable<>();
    private static final Hashtable<String, PlayerClassItem> PLAYER_CLASS_ITEMS = new Hashtable<>();
    private static final Hashtable<String, ItemStack> REGISTERED_JSON_ITEMS = new Hashtable<>();

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

    public static ItemStack getJsonItem(String itemName) {
        if (REGISTERED_JSON_ITEMS.containsKey(itemName)) {
            return REGISTERED_JSON_ITEMS.get(itemName);
        }

        return null;
    }

    /**
     * Will replace the item if the itemName is already registered
     * @param itemName The name of the item, this is used to retrieve the item later
     * @param item The item to register, the item must be set here if custom items in custom inventories are to be used
     */
    public static void registerJsonItem(String itemName, ItemStack item) {
        REGISTERED_JSON_ITEMS.put(itemName, item);
    }
}
