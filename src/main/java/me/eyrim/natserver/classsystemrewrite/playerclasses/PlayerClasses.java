package me.eyrim.natserver.classsystemrewrite.playerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.AbilityItem;
import me.eyrim.natserver.classsystemrewrite.itemutil.ItemBuilder;
import me.eyrim.natserver.classsystemrewrite.middlemen.TempComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;

import java.util.List;

/**
 * All the player classes the server uses
 */
public enum PlayerClasses {
    /**
     * The assassin class, focussed on stealth
     */
    ASSASSIN(
            new PlayerClassItem(
                    new ItemBuilder(Material.SADDLE, 1)
                            .setDisplayName(
                                    Component.text(
                                            "Assassin"
                                    ).color(
                                            TextColor.color(
                                                    10, 255, 60
                                            )
                                    ).decorate(
                                            TextDecoration.BOLD
                                    )
                            ).addLore(
                                    Component.text(
                                            "Sneaky and stuff idk this is temp"
                                    ).color(
                                            TextColor.color(
                                                    250, 250, 75
                                            )
                                    )
                            ).setCustomModelData(
                                    1234
                            ).setUnbreakable(
                                    true
                            ).create()
            ),
            "Assassin",
            null),
    SOLDIER(null, "Soldier", null);

    private final PlayerClassItem displayItem;
    private final String playerClassName;
    private final AbilityItem[] abilities;

    private PlayerClasses(PlayerClassItem displayItem, String playerClassName, AbilityItem[] abilities) {
        this.displayItem = displayItem;
        this.playerClassName = playerClassName;
        this.abilities = abilities;
    }

    public PlayerClassItem getDisplayItem() { return this.displayItem; }

    public String getPlayerClassName() { return this.playerClassName; }

    public AbilityItem[] getAbilities() { return this.abilities; }
}
