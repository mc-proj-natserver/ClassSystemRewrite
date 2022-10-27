package me.eyrim.natserver.classsystemrewrite.playerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.AbilityItem;
import me.eyrim.natserver.classsystemrewrite.itemutil.ItemPool;

/**
 * All the player classes the server uses <br><br>
 *
 * <strong>THIS ENUM IS INCOMPLETE AND DOES NOT CONTAIN ALL OF THE PLAYER CLASSES, NOR DOES IT REFERENCE THEIR SUBCLASSES</strong>
 */
public enum PlayerClasses {
    /**
     * The assassin class, focussed on stealth
     */
    ASSASSIN(new PlayerClassItem(ItemPool.getJsonItem("assassin_display_item")), "Assassin", null),
    /**
     * The Soldier class, focussed on todo
     */
    SOLDIER(new PlayerClassItem(ItemPool.getJsonItem("soldier_display_item")), "Soldier", null);

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
