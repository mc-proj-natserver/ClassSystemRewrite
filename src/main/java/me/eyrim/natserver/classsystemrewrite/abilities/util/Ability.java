package me.eyrim.natserver.classsystemrewrite.abilities.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Ability {
    public String getAbilityName();
    public int getModelData();
    public ItemStack getItem();
    public void activate(Player player);
}
