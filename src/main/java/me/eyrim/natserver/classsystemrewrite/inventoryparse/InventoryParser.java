package me.eyrim.natserver.classsystemrewrite.inventoryparse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.eyrim.natserver.classsystemrewrite.util.FileHandling;

public class InventoryParser {
    private static Gson _Gson = new GsonBuilder().setPrettyPrinting().create();

    public static SkillTreeInventory serializeInventory(String filePath) {
        String fileData = FileHandling.readFileToString(filePath);
        SkillTreeInventory fromJson = _Gson.fromJson(fileData, SkillTreeInventory.class);

        return fromJson;
    }
}
