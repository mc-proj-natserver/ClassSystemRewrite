package me.eyrim.natserver.classsystemrewrite.middlemen;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class TempComponent {
    private String text;
    private int[] rgb;
    private String[] decoration;

    public TempComponent(
            String text,
            int[] rgb,
            String[] decoration
    ) {
        this.text = text;
        this.rgb = rgb;
        this.decoration = decoration;
    }

    public Component toComponent() {
        Component comp = Component.text(
                text
        ).color(
                TextColor.color(
                        rgb[0], rgb[1], rgb[2]
                )
        );

        for (String s : decoration) {
            comp = comp.decorate(TextDecoration.valueOf(s));
        }

        return comp;
    }
}
