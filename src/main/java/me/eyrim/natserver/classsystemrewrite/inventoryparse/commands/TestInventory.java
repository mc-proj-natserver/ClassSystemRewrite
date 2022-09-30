package me.eyrim.natserver.classsystemrewrite.inventoryparse.commands;

import me.eyrim.natserver.classsystemrewrite.inventoryparse.InventoryParser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class TestInventory implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;
        Inventory inv = InventoryParser.serializeInventory("C:\\Users\\gamin\\Desktop\\natserver\\ClassSystemRewrite\\src\\main\\resources\\classSelectInventory.json").getInventory();
        p.openInventory(inv);

        return true;
    }
}
