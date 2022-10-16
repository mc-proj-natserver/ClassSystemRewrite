package me.eyrim.natserver.classsystemrewrite.middlemen;

import com.google.gson.annotations.SerializedName;
import me.eyrim.natserver.classsystemrewrite.itemutil.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.logging.Level;

public class TempItem {
    private String material;
    private int quantity;
    private Hashtable<String, Integer> enchants;
    private List<TempComponent> lore;
    @SerializedName("item_flags")
    private String[] itemFlags;
    @SerializedName("custom_model_data")
    private int customModelData;
    @SerializedName("is_unbreakable")
    private boolean isUnbreakable;
    @SerializedName("item_name")
    private TempComponent itemName;

    public TempItem(
            String material,
            int quantity,
            Hashtable<String, Integer> enchants,
            List<TempComponent> lore,
            String[] itemFlags,
            int customModelData,
            boolean isUnbreakable,
            TempComponent itemName
    ) {
        this.material = material;
        this.quantity = quantity;
        this.enchants = enchants;
        this.lore = lore;
        this.itemFlags = itemFlags;
        this.customModelData = customModelData;
        this.isUnbreakable = isUnbreakable;
        this.itemName = itemName;
    }

    // TODO: 13/10/2022 Everything below here should probably be refactored
    public ItemStack toItemStack() {
        try {
            HashMap<Enchantment, Integer> enchants = stringsToEnchants(this.enchants);
            ItemFlag[] flags = stringsToItemFlags(this.itemFlags);
            List<Component> convertedToComponents = tempComponentToComponent(this.lore);

            ItemStack item = new ItemBuilder(Material.getMaterial(this.material), this.quantity)
                    .addEnchantment(
                            stringsToEnchants(this.enchants)
                    ).setCustomModelData(
                            this.customModelData
                    ).setUnbreakable(
                            this.isUnbreakable
                    ).addFlag(
                            flags
                    ).setLore(
                            convertedToComponents
                    ).setDisplayName(
                            this.itemName.toComponent()
                    ).create();

            return item;
        } catch (Exception e) {
            // Log the failure to register the item
            Bukkit.getLogger().log(Level.WARNING, e.getMessage());

            return null;
        }
    }

    private static List<Component> tempComponentToComponent(List<TempComponent> lore) {
        List<Component> newLore = new ArrayList<>(lore.size());

        for (TempComponent tc : lore) {
            newLore.add(tc.toComponent());
        }

        return newLore;
    }

    private static HashMap<Enchantment, Integer> stringsToEnchants(Hashtable<String, Integer> enchants) throws IllegalArgumentException {
        HashMap<Enchantment, Integer> newMap = new HashMap<>();
        Enumeration<String> keyEnum = enchants.keys();
        String currentKey;
        Enchantment enchantment;

        while (keyEnum.hasMoreElements()) {
            currentKey = keyEnum.nextElement();
            enchantment = Enchantment.getByKey(new NamespacedKey(NamespacedKey.MINECRAFT, currentKey));
            if (enchantment == null) {
                Bukkit.getLogger().log(Level.WARNING, "Enchantment: " + currentKey + " not found");
                throw new IllegalArgumentException("Enchantment: " + currentKey + " not found");
            }

            newMap.put(enchantment, enchants.get(currentKey));
        }

        return newMap;
    }

    private static ItemFlag[] stringsToItemFlags(String[] flags) {
        List<ItemFlag> newFlags = new ArrayList<>(flags.length);

        for (String s : flags) {
            newFlags.add(ItemFlag.valueOf(s));
        }

        return newFlags.toArray(new ItemFlag[flags.length]);
    }
}





















