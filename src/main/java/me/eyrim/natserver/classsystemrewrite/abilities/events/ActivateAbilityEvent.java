package me.eyrim.natserver.classsystemrewrite.abilities.events;

import me.eyrim.natserver.classsystemrewrite.abilities.items.AbilityItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ActivateAbilityEvent implements Listener {
    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            //TODO: Test
            if (event.getItem() instanceof AbilityItem) {
                // Cast the item to an ability item and activate its ability
                ((AbilityItem) event.getItem()).activateAbility(event.getPlayer());
            }
        }
    }
}
