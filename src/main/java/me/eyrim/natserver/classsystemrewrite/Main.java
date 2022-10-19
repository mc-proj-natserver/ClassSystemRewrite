package me.eyrim.natserver.classsystemrewrite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.eyrim.natserver.classsystemrewrite.abilities.commands.GiveAbilityItemCommand;
import me.eyrim.natserver.classsystemrewrite.abilities.io.FileHandling;
import me.eyrim.natserver.classsystemrewrite.inventoryutil.InventoryParser;
import me.eyrim.natserver.classsystemrewrite.inventoryutil.SkillTreeInventory;
import me.eyrim.natserver.classsystemrewrite.itemutil.ItemPool;
import me.eyrim.natserver.classsystemrewrite.middlemen.TempItem;
import me.eyrim.natserver.classsystemrewrite.testevents.PlayerDropItemEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    public static SkillTreeInventory inventory;

    @Override
    public void onEnable() {
        // Register commands
        registerCommands();
        registerEvents();
        registerCustomItems();
        // Relies on the above working
        registerCustomInventories();
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
        File[] customItems = new File("C:\\Users\\gamin\\Desktop\\natserver\\ClassSystemRewrite\\src\\main\\resources\\customItems").listFiles();
        String itemName;
        ItemStack item;
        Gson gson = new GsonBuilder().serializeNulls().create();

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
                item = deserialiseTempItem(file.getAbsolutePath());

                // ItemName will be extension-less file name
                itemName = FileHandling.removeExtension(file.getName());

                ItemPool.registerJsonItem(itemName, item);
            }
        }
    }

    private static void registerCustomInventories() {
        // Custom Items are stored in resources/skillTrees

        // Gets the children of the above directory
        File[] skillTrees = new File("C:\\Users\\gamin\\Desktop\\natserver\\ClassSystemRewrite\\src\\main\\resources\\skillTrees").listFiles();
        String inventoryName;
        SkillTreeInventory inventory;
        Gson gson = new GsonBuilder().serializeNulls().create();

        // If there are no children (meaning there are no custom items to load)
        if (skillTrees == null) {
            return;
        }

        // Iterate through each file
        for (File file : skillTrees) {
            if (file.isDirectory()) { continue; }
            if (file.isHidden()) { continue; }

            // If the file is a json file
            if (file.getPath().matches(".*\\.json")) {
                inventory = InventoryParser.serializeInventory(file.getAbsolutePath());

                System.out.println(file.getAbsolutePath());

                Main.inventory = inventory;
            }

            /*// If the file is a json file
            if (file.getPath().matches(".*\\.json")) {
                item = deserializeJsonFile(file);

                // ItemName will be extension-less file name
                itemName = FileHandling.removeExtension(file.getName());

                ItemPool.registerJsonItem(itemName, item);*/
        }
    }

    private static ItemStack deserialiseTempItem(String filePath) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = FileHandling.readFileToString(filePath);
        TempItem item = gson.fromJson(json, TempItem.class);

        return item.toItemStack();
    }

    private void registerCommands() {
        //getCommand("customItem").setExecutor(new GiveAbilityItemCommand());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerDropItemEvent(), this);
    }
}
