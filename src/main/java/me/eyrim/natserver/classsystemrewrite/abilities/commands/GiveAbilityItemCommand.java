package me.eyrim.natserver.classsystemrewrite.abilities.commands;

import me.eyrim.natserver.classsystemrewrite.abilities.AbilityItem;
import me.eyrim.natserver.classsystemrewrite.itemutil.ItemPool;
import me.eyrim.natserver.classsystemrewrite.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveAbilityItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) { return false; }
        if (args.length != 1) { return false; }

        Player player = (Player) sender;
        AbilityItem item;

        // If the player has no slots in their inventory
        if (player.getInventory().firstEmpty() == -1) {
            // Show them an error title
            player.showTitle(Main.getErrorTitle("You Need An Empty Slot In Your Inventory!"));
            
            return false;
        }

        try {
            item = ItemPool.getAbilityItemFromAbilityName(args[0]);

            // TODO: 01/10/2022 Check the player doesn't have the ability item in their inv already
            player.getInventory().addItem(item);
            return true;
        } catch (IllegalArgumentException exception) { // If the player didn't enter a valid ability name
            // Show them an error title
            player.showTitle(Main.getErrorTitle("An Ability Item Of That Type Was Not Found!"));
        }

        return false;
    }
}
