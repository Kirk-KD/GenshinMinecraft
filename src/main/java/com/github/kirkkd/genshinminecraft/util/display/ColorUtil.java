package com.github.kirkkd.genshinminecraft.util.display;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ColorUtil {
    public static @Nullable Color chatColorToColor(@NotNull ChatColor chatColor) {
        switch (chatColor) {
            case BLACK -> {
                return Color.fromRGB(0, 0, 0);
            }
            case DARK_BLUE -> {
                return Color.fromRGB(0, 0, 170);
            }
            case DARK_GREEN -> {
                return Color.fromRGB(0, 170, 0);
            }
            case DARK_AQUA -> {
                return Color.fromRGB(0, 170, 170);
            }
            case DARK_RED -> {
                return Color.fromRGB(170, 0, 0);
            }
            case DARK_PURPLE -> {
                return Color.fromRGB(170, 0, 170);
            }
            case GOLD -> {
                return Color.fromRGB(255, 170, 0);
            }
            case GRAY -> {
                return Color.fromRGB(170, 170, 170);
            }
            case DARK_GRAY -> {
                return Color.fromRGB(85, 85, 85);
            }
            case BLUE -> {
                return Color.fromRGB(85, 85, 255);
            }
            case GREEN -> {
                return Color.fromRGB(85, 255, 85);
            }
            case AQUA -> {
                return Color.fromRGB(85, 255, 255);
            }
            case RED -> {
                return Color.fromRGB(255, 85, 85);
            }
            case LIGHT_PURPLE -> {
                return Color.fromRGB(255, 85, 255);
            }
            case YELLOW -> {
                return Color.fromRGB(255, 255, 85);
            }
            case WHITE -> {
                return Color.fromRGB(255, 255, 255);
            }
            default -> {
                return null;
            }
        }
    }
}
