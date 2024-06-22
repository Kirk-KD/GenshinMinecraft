package com.github.kirkkd.genshinminecraft.elemental;

import org.bukkit.ChatColor;

public enum ElementalInfo {
    ANEMO(ChatColor.DARK_AQUA, "anemo"),
    GEO(ChatColor.YELLOW, "geo"),
    ELECTRO(ChatColor.LIGHT_PURPLE, "electro"),
    DENDRO(ChatColor.DARK_GREEN, "dendro"),
    HYDRO(ChatColor.BLUE, "hydro"),
    CRYO(ChatColor.AQUA, "cryo"),
    PYRO(ChatColor.GOLD, "pyro"),

    VAPORIZE(ChatColor.GOLD, "vaporize"),
    OVERLOAD(ChatColor.RED, "overload");

    public final ChatColor chatColor;
    public final String nameLower;
    public final String nameCapitalized;
    public final String nameUpper;
    public final String nameLowerStylized;
    public final String nameCapitalizedStylized;
    public final String nameUpperStylized;

    ElementalInfo(ChatColor chatColor, String name) {
        this.chatColor = chatColor;
        nameLower = name.toLowerCase();
        nameCapitalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        nameUpper = name.toUpperCase();
        nameLowerStylized = chatColor + nameLower;
        nameCapitalizedStylized = chatColor + nameCapitalized;
        nameUpperStylized = chatColor + nameUpper;
    }
}
