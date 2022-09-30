package me.eyrim.natserver.classsystemrewrite.customitemparse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.eyrim.natserver.classsystemrewrite.util.FileHandling;

public class ItemParser {
    private static Gson _Gson = new GsonBuilder().setPrettyPrinting().create();

    public static CustomItem serializeItem(String filePath) {
        String fileData = FileHandling.readFileToString(filePath);
        CustomItem item = _Gson.fromJson(fileData, CustomItem.class);
        //ItemStack item = new ItemStack(Material.STICK, 1);
        return item;
    }
}
