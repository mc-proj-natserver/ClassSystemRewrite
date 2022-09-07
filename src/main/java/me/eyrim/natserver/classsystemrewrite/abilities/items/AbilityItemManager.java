package me.eyrim.natserver.classsystemrewrite.abilities.items;

import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbilityItemManager {
    public static AbilityItem createItem(String abilityName, int modelData) {
        AbilityItem item = new AbilityItem(abilityName, Material.BIRCH_BUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        item.addUnsafeEnchantment(Enchantment.LUCK, 1);

        meta.displayName(Component.text(abilityName)
                .color(TextColor.color(123, 3, 252)));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(modelData);

        lore.add(Component.text("Activate this to " + abilityName)
                .color(TextColor.color(255, 0, 98)));
        meta.lore(lore);

        return item;
    }
}
