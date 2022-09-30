package me.eyrim.natserver.classsystemrewrite.playerclasses.mainplayerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import me.eyrim.natserver.classsystemrewrite.playerclassitems.PlayerClassItem;
import me.eyrim.natserver.classsystemrewrite.playerclassitems.PlayerClassItemPool;
import org.bukkit.inventory.ItemStack;

public class MagePlayerClass implements PlayerClass {
    private static final String _CLASS_NAME = "Mage";
    private static final int _MODEL_DATA = 1236;
    private static final Ability[] _ABILITIES = null;
    private static final PlayerClassItem _ITEM = PlayerClassItemPool.getItem("Mage");

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
