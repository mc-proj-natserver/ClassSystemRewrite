package me.eyrim.natserver.classsystemrewrite.playerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.Ability;
import me.eyrim.natserver.classsystemrewrite.inventoryutil.SkillTreeInventory;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface PlayerClass {
    public Component getDisplayName();
    public Ability[] getAbilities();
    public int getModelData();
    public void showSkillTree(Player player, int level);
    public void registerSkillTreeInventory(SkillTreeInventory inventory, int level);
}
