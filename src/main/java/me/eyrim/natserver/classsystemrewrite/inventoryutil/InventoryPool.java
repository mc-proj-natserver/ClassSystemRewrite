package me.eyrim.natserver.classsystemrewrite.inventoryutil;

import java.util.Hashtable;

public class InventoryPool {
    private static final Hashtable<String, SkillTreeInventory> SKILL_TREE_INVENTORIES = new Hashtable<>();

    public static SkillTreeInventory getSkillTreeInventoryFromInventoryName(String inventoryName) {
        if (SKILL_TREE_INVENTORIES.containsKey(inventoryName)) {
            return SKILL_TREE_INVENTORIES.get(inventoryName);
        }

        throw new IllegalArgumentException();
    }

    public static void registerSkillTreeInventory(String inventoryName, SkillTreeInventory inventory) {
        SKILL_TREE_INVENTORIES.put(inventoryName, inventory);
    }
}
