package me.eyrim.natserver.classsystemrewrite.abilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.eyrim.natserver.classsystemrewrite.abilities.io.FileHandling;
import me.eyrim.natserver.classsystemrewrite.abilities.itemutil.ItemPool;
import me.eyrim.natserver.classsystemrewrite.abilities.middlemen.TempItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register commands
        registerCommands();
        registerEvents();
        registerCustomItems();
    }

    @Override
    public void onDisable() {
    }

    public static Title getErrorTitle(String titleText) {
        return Title.title(
                Component.text(
                        titleText
            ).color(
                    TextColor.color(255, 20, 130)
            ).decorate(
                    TextDecoration.BOLD
            ).decorate(
                    TextDecoration.UNDERLINED
            ),
                Component.empty());
    }

    private static void registerCustomItems() {
        // Custom Items are stored in resources/customItems

        // Gets the children of the above directory
        File[] customItems = new File("customItems/").listFiles();
        String itemName;
        ItemStack item;

        // If there are no children (meaning there are no custom items to load)
        if (customItems == null) {
            return;
        }

        // Iterate through each file
        for (File file : customItems) {
            if (file.isDirectory()) { continue; }
            if (file.isHidden()) { continue; }

            // If the file is a json file
            if (file.getPath().matches(".*\\.json")) {
                item = deserializeJsonFile(file);

                // ItemName will be extension-less file name
                itemName = FileHandling.removeExtension(file.getName());

                ItemPool.registerJsonItem(itemName, item);
            }
        }
    }

    private static ItemStack deserializeJsonFile(File file) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        TempItem item = gson.fromJson(
                FileHandling.readFileToString(file.getAbsolutePath()),
                TempItem.class
        );

        return item.toItemStack();
    }

    private static void registerCommands() {

    }

    private static void registerEvents() {

    }
}
