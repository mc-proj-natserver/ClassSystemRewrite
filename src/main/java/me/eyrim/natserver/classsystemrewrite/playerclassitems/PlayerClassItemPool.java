package me.eyrim.natserver.classsystemrewrite.playerclassitems;

import java.util.Dictionary;
import java.util.Hashtable;

public class PlayerClassItemPool {
    private static final Dictionary<String, PlayerClassItem> _Items = new Hashtable<String, PlayerClassItem>();

    public static void addItem(String key, PlayerClassItem playerClassItem) {
        _Items.put(key, playerClassItem);
    }

    public static PlayerClassItem getItem(String key) {
        if (_Items.get(key) != null) {
            return _Items.get(key);
        }

        return null;
    }
}
