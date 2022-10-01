package me.eyrim.natserver.classsystemrewrite.abilities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register commands
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
}
