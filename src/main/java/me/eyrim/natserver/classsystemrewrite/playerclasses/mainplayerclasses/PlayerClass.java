package me.eyrim.natserver.classsystemrewrite.playerclasses.mainplayerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import org.bukkit.inventory.ItemStack;

public interface PlayerClass {
    public ItemStack getDisplayItem();
    public String getDisplayName();
    public Ability[] getAbilities();
    public int getModelData();
}
