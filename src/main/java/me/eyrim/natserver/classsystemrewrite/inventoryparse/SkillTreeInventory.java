package me.eyrim.natserver.classsystemrewrite.inventoryparse;

import com.google.gson.annotations.SerializedName;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class SkillTreeInventory implements InventoryHolder {
    @SerializedName("name")
    private String _Name;
    @SerializedName("size")
    private int _Size;
    @SerializedName("rows")
    private List<List<String>> _Rows;
    @SerializedName("items")
    private Hashtable<String, String> _Items;

    @Override
    public @NotNull Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(this, _Size, Component.text(_Name));
        List<String> currentRow;
        int currentSlot = 0;

        // For every row
        for (List<String> row : _Rows) { // i = current row index
            currentRow = row;
            for (String s : currentRow) { // j = current position on that row (0-9)
                inv.setItem(currentSlot, getItem(s));

                currentSlot += 1;
            }
        }

        return inv;
    }

    private ItemStack getItem(String slot) { // TODO: 18/09/2022 Add capability for custom items
        if (Objects.equals(slot, " ")) { return new ItemStack(Material.AIR, 1); }

        return new ItemStack(Material.getMaterial(_Items.get(slot)), 1);

    }
}















