package me.eyrim.natserver.classsystemrewrite.abilities.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AbilityItemPool {
    private static Hashtable<String, AbilityItem> _Items = new Hashtable<>();


    public static void addItem(String key, Object item) {
        if (item instanceof AbilityItem) {
            _Items.put(key, (AbilityItem) item);
        }

        throw new IllegalArgumentException();
    }

    public static AbilityItem getItem(String key) {
        if (_Items.containsKey(key)) {
            return _Items.get(key);
        }

        throw new IllegalArgumentException();
    }

    public static AbilityItem createItem(String itemName, int modelData) {
        AbilityItem item = new AbilityItem(itemName, Material.BIRCH_BUTTON, 1);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        item.addUnsafeEnchantment(Enchantment.LUCK, 1);

        meta.displayName(Component.text(itemName)
                .color(TextColor.color(123, 3, 252)));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(modelData);

        lore.add(Component.text("Activate this to " + itemName)
                .color(TextColor.color(255, 0, 98)));
        meta.lore(lore);

        return item;
    }
}
