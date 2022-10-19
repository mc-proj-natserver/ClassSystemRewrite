package me.eyrim.natserver.classsystemrewrite.playerclasses.assassin;

import me.eyrim.natserver.classsystemrewrite.abilities.Ability;
import me.eyrim.natserver.classsystemrewrite.inventoryutil.SkillTreeInventory;
import me.eyrim.natserver.classsystemrewrite.playerclasses.PlayerClass;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Assassin implements PlayerClass {
    // TODO: 16/10/2022 Fill out \/\/\/\/\/\/\/
    private static List<Ability> ABILITIES;
    private static List<SkillTreeInventory> SKILL_TREES;

    static {
        ABILITIES = new ArrayList<>();
        SKILL_TREES = new ArrayList<>();
    }

    @Override
    public Component getDisplayName() {
        return Component.text("Assassin");
    }

    @Override
    public Ability[] getAbilities() {
        throw new NotImplementedException();
    }

    @Override
    public int getModelData() {
        return 1234; // TODO: 16/10/2022 Make a model data schema
    }

    @Override
    public void showSkillTree(Player player, int level) {
        player.openInventory(SKILL_TREES.get(level).getInventory());
    }

    @Override
    public void registerSkillTreeInventory(SkillTreeInventory inventory, int level) {
        SKILL_TREES.set(level, inventory);
    }
}
