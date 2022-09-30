package me.eyrim.natserver.classsystemrewrite.playerclasses.selection;

import me.eyrim.natserver.classsystemrewrite.playerclassitems.PlayerClassItemPool;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Dictionary;
import java.util.Hashtable;

public class MainPlayerClassSelection implements InventoryHolder {
    private Inventory _Inv;
    private final int _INV_SIZE = 54;
    private final Component _INV_NAME = Component.text("Select a Main Class!")
            .color(TextColor.color(138, 191, 164));
    private final Dictionary<Integer, ItemStack> _ItemToDict = new Hashtable<Integer, ItemStack>() {{
        put(9, PlayerClassItemPool.getItem("Assassin")); // Will be a Dagger
        put(10, PlayerClassItemPool.getItem("Beserker")); // Will be an Axe
        put(11, PlayerClassItemPool.getItem("Mage")); // Will be a Staff
        put(12, PlayerClassItemPool.getItem("Monk")); // Will be a Fist
        put(13, PlayerClassItemPool.getItem("Soldier")); // Will be an ak-47 :)
    }};

    public MainPlayerClassSelection() {
        init();
    }

    private void init() {
        // Create actual inv
        _Inv = Bukkit.createInventory(this, _INV_SIZE, _INV_NAME);
        // Populate

    }

    @Override
    public @NotNull Inventory getInventory() {
        return _Inv;
    }
}
