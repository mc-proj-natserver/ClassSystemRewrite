package me.eyrim.natserver.classsystemrewrite.playerclasses.selection;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class MainPlayerClassSelection implements InventoryHolder {
    private Inventory _Inv;
    private final int _INV_SIZE = 54;
    private final Component _INV_NAME = Component.text("Select a Main Class!")
            .color(TextColor.color(138, 191, 164));

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
