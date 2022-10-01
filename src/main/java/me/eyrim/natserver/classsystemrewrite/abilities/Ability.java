package me.eyrim.natserver.classsystemrewrite.abilities;

import org.bukkit.entity.Player;

public interface Ability {
    public String getAbilityName();
    public AbilityItem getAbilityItem();
    public void activate(Player player);
}
