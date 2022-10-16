package me.eyrim.natserver.classsystemrewrite.itemutil;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemBuilder {
    private ItemStack item;

    public ItemBuilder(Material material, int count) {
        item = new ItemStack(material, count);
    }

    public ItemBuilder addEnchantment(HashMap<Enchantment, Integer> enchants) {
        item.addUnsafeEnchantments(enchants);

        return this;
    }

    public ItemBuilder setLore(List<Component> lore) {
        item.lore(lore);

        return this;
    }

    public ItemBuilder addLore(Component lore) {
        List<Component> currentLore = item.lore();

        // Check the lore isn't null
        if (currentLore == null) {
            // If it is then set it to empty List
            item.lore(new ArrayList<Component>(1));
        }
        currentLore.add(lore);
        item.lore(currentLore);

        return this;
    }

    public ItemBuilder addFlag(ItemFlag[] flags) {
        for (ItemFlag flag : flags) {
            item.addItemFlags(flag);
        }

        return this;
    }

    public ItemBuilder setQuantity(int quantity) {
        item.setAmount(quantity);

        return this;
    }

    public ItemBuilder setCustomModelData(int customModelData) {
        item.getItemMeta().setCustomModelData(customModelData);

        return this;
    }

    public ItemBuilder setDisplayName(Component displayName) {
        item.getItemMeta().displayName(displayName);

        return this;
    }

    public ItemBuilder setUnbreakable(boolean isBreakable) {
        item.getItemMeta().setUnbreakable(isBreakable);

        return this;
    }

    public ItemStack create() {
        return item;
    }
}
