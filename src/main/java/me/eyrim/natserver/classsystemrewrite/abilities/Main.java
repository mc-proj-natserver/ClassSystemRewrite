package me.eyrim.natserver.classsystemrewrite.abilities;

import me.eyrim.natserver.classsystemrewrite.abilities.io.FileHandling;
import me.eyrim.natserver.classsystemrewrite.abilities.itemutil.ItemPool;
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

        // If there are no children
        if (customItems == null) {
            return;
        }

        // Iterate through each file
        for (File file : customItems) {
            if (file.isDirectory()) { continue; }
            if (file.isHidden()) { continue; }

            // ItemName will be extension-less file name
            itemName = FileHandling.removeExtension(file.getName());
            // Read byte file and convert it into an item stack
            item = ItemStack.deserializeBytes(FileHandling.readBytes(file.getPath()));

            ItemPool.registerJsonItem(itemName, item);
        }
    }

    private static void registerCommands() {

    }

    private static void registerEvents() {

    }
}
