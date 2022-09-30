package me.eyrim.natserver.classsystemrewrite.playerclassitems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PlayerClassItem extends ItemStack {
    private final int _SelectionInventoryIndex;
    private final String _PlayerClassName;

    public PlayerClassItem(Material material, int count, String playerClassName, int selectionInventoryIndex) {
        super(material, count);

        this._SelectionInventoryIndex = selectionInventoryIndex;
        this._PlayerClassName = playerClassName;
    }

    public int getSelectionInventoryIndex() {
        return this._SelectionInventoryIndex;
    }
}
