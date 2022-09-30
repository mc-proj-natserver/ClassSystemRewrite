package me.eyrim.natserver.classsystemrewrite.playerclassitems;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerClassItemManager {
    public static PlayerClassItem createItem(String playerClassName, int modelData) {
        PlayerClassItem item = new PlayerClassItem(Material.BIRCH_BUTTON, 1, playerClassName, 9);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();

        item.addUnsafeEnchantment(Enchantment.LUCK, 1);

        meta.displayName(Component.text(playerClassName)
                .color(TextColor.color(180, 212, 142)));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(modelData);

        lore.add(Component.text("Click me to receive the " + playerClassName + " player class!")
                .color(TextColor.color(227, 182, 109))
                .decorate(TextDecoration.UNDERLINED));
        meta.lore(lore);

        PlayerClassItemPool.addItem(playerClassName, item);

        return item;
    }
}
