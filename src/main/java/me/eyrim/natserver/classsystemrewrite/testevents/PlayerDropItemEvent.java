package me.eyrim.natserver.classsystemrewrite.testevents;

import me.eyrim.natserver.classsystemrewrite.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDropItemEvent implements Listener {
    @EventHandler
    public static void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
        event.getPlayer().openInventory(Main.inventory.getInventory());
    }
}
