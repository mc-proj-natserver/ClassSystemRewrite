package me.eyrim.natserver.classsystemrewrite;

import me.eyrim.natserver.classsystemrewrite.abilities.events.ActivateAbilityEvent;
import me.eyrim.natserver.classsystemrewrite.abilities.items.commands.GiveAbilityItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClassSystemRewrite extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        initCommands();
        initEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initCommands() {
        getCommand("giveability").setExecutor(new GiveAbilityItem());
    }

    private void initEvents() {
        getServer().getPluginManager().registerEvents(new ActivateAbilityEvent(), this);
    }
}
