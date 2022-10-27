package me.eyrim.natserver.classsystemrewrite.playerclasses;

import org.bukkit.inventory.ItemStack;

import java.util.Hashtable;

public class PlayerClassItem extends ItemStack {
    private ItemStack ITEM = null;


    public PlayerClassItem(ItemStack item) {
        this.ITEM = item;
    }
}
