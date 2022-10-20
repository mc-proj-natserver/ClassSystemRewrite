package me.eyrim.natserver.classsystemrewrite.abilities.events;

import me.eyrim.natserver.classsystemrewrite.abilities.AbilityItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Contains the events for activating an ability. <br/><br/>
 * This method actually listens for PlayerInteractEvent's and then deduces whether an ability item was activated. <br\><br\>
 * If an ability item was activated, then the ability will be activated.
 */
public class ActivateAbilityEvent implements Listener {
    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        // Check it was a right click
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            // Check if the player is holding an ability item
            if (event.getItem() instanceof AbilityItem) {
                // TODO: 01/10/2022 Test
                ((AbilityItem) event.getItem()).getAbility().activate(event.getPlayer());
            }
        }
    }
}
