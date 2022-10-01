package me.eyrim.natserver.classsystemrewrite.abilities.items.commands;

import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItemPool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveAbilityItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) { return false; }
        if (args.length > 1) { return false; }

        Player player = (Player) sender;
        Ability ability = AbilityItemPool.getItem(args[0]);
        //Ability ability = AbilityItemPool.getAbilityFromName(args[0]);

        // If the inventory is full
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage("§6§lYou need an empty slot in your inventory to receive this item!");
            return false;
        }
        // If the ability argument was incorrect
        if (ability == null) {
            return false;
        }

        // Gets the ability item from the pool and adds it to the player's inventory
        player.getInventory().addItem(ability.getItem());

        return true;
    }
}
