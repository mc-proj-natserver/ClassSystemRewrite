package me.eyrim.natserver.classsystemrewrite.playerclasses.mainplayerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import me.eyrim.natserver.classsystemrewrite.playerclassitems.PlayerClassItemPool;
import org.bukkit.inventory.ItemStack;

public class MonkPlayerClass implements PlayerClass {
    private static final String _CLASS_NAME = "Monk";
    private static final int _MODEL_DATA = 1237;
    private static final Ability[] _ABILITIES = null;
    private static final ItemStack _ITEM = PlayerClassItemPool.getItem("Monk");

    @Override
    public ItemStack getDisplayItem() {
        return _ITEM;
    }

    @Override
    public String getDisplayName() {
        return _CLASS_NAME;
    }

    @Override
    public Ability[] getAbilities() {
        return null;
    }

    @Override
    public int getModelData() {
        return _MODEL_DATA;
    }
}
