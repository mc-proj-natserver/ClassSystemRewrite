package me.eyrim.natserver.classsystemrewrite.playerclasses;

import org.bukkit.inventory.ItemStack;

public class PlayerClassItem extends ItemStack {
    private final PlayerClass PLAYER_CLASS;

    public PlayerClassItem(PlayerClass playerClass) {
        this.PLAYER_CLASS = playerClass;
    }

    public PlayerClass getPlayerClassItem() {
        return this.PLAYER_CLASS;
    }
}
