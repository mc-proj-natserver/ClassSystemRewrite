package me.eyrim.natserver.classsystemrewrite.abilities.util;

import me.eyrim.natserver.classsystemrewrite.abilities.Dash;

import java.util.Objects;

public class AbilityItemPool {
    private static final Ability[] _Abilities = new Ability[] {
            new Dash()
    };

    public static Ability getAbilityFromName(String name) {
        for (Ability a : _Abilities) {
            if (Objects.equals(a.getAbilityName(), name)) {
                return a;
            }
        }

        return null;
    }
}
