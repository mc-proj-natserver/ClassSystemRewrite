package me.eyrim.natserver.classsystemrewrite.playerclasses.mainplayerclasses;

import me.eyrim.natserver.classsystemrewrite.abilities.util.Ability;
import me.eyrim.natserver.classsystemrewrite.playerclasses.items.PlayerClassItem;
import me.eyrim.natserver.classsystemrewrite.playerclasses.items.PlayerClassItemManager;
import org.bukkit.inventory.ItemStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BeserkerPlayerClass implements PlayerClass {
    private static final String _CLASS_NAME = "Beserker";
    private static final int _MODEL_DATA = 1235;
    private static final Ability[] _ABILITIES = null;
    private static final PlayerClassItem _ITEM = PlayerClassItemManager.createItem(_CLASS_NAME, _MODEL_DATA);

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
        throw new NotImplementedException();
    }

    @Override
    public int getModelData() {
        return _MODEL_DATA;
    }
}
