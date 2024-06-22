package com.github.kirkkd.genshinminecraft.util.display;

import com.github.kirkkd.genshinminecraft.elemental.IElemental;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.TextDisplay;

public abstract class ReactionTextDisplay extends TemporaryTextDisplay implements IElemental {
    @Override
    public Color getDisplayBackgroundColor() {
        Color color = ColorUtil.chatColorToColor(getElementalInfo().chatColor);
        if (color != null) return color.setAlpha(50);
        return Color.fromARGB(0, 0, 0, 0);
    }

    @Override
    public void configureDisplay(TextDisplay textDisplay) {
        super.configureDisplay(textDisplay);
        String text = textDisplay.getText();
        if (text != null)
            textDisplay.setText(ChatColor.getLastColors(text) + ChatColor.MAGIC + "#" + text + ChatColor.MAGIC + "#");
    }
}
