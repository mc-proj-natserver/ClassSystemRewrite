package me.eyrim.natserver.classsystemrewrite.playerclasses;

import org.bukkit.inventory.ItemStack;

import java.util.Hashtable;

public class PlayerClassItem extends ItemStack {
    private ItemStack ITEM = null;
    private static final Hashtable<String, PlayerClassItem> PLAYER_CLASS_ITEMS = new Hashtable<>();

    static {
        for (PlayerClasses playerClass : PlayerClasses.values()) {
            PlayerClassItem.PLAYER_CLASS_ITEMS.put(playerClass.getPlayerClassName(), playerClass.getDisplayItem());
        }
    }

    public PlayerClassItem(ItemStack item) {
        this.ITEM = item;
    }
}
