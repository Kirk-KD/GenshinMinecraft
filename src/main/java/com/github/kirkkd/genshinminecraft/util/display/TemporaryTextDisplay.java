package com.github.kirkkd.genshinminecraft.util.display;

import com.github.kirkkd.genshinminecraft.GenshinMinecraft;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TextDisplay;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TemporaryTextDisplay {
    public static final NamespacedKey KEY = new NamespacedKey(GenshinMinecraft.INSTANCE, "TemporaryTextDisplay");

    public static boolean isTemporaryTextDisplay(Entity entity) {
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        return pdc.has(KEY);
    }

    public static void removeAllDisplays() {
        List<World> worlds = GenshinMinecraft.INSTANCE.getServer().getWorlds();
        for (World world : worlds) {
            List<TextDisplay> textDisplays = (List<TextDisplay>) world.getEntitiesByClass(TextDisplay.class);
            for (TextDisplay textDisplay : textDisplays) {
                if (isTemporaryTextDisplay(textDisplay)) textDisplay.remove();
            }
        }
    }

    public abstract String getDisplayText();

    public abstract long getDisplayTicks();

    public abstract Location getDisplayLocation();

    public abstract double getDisplayLocationOffset();

    public Color getDisplayBackgroundColor() {
        return Color.fromARGB(0, 0, 0, 0);
    }

    public void configureDisplay(TextDisplay textDisplay) {
        textDisplay.setSeeThrough(true);
        textDisplay.setTextOpacity((byte) 1);
        textDisplay.setAlignment(TextDisplay.TextAlignment.CENTER);
        textDisplay.setBillboard(Display.Billboard.CENTER);
        textDisplay.setBackgroundColor(getDisplayBackgroundColor());
    }

    public void summonTextDisplay() {
        World world = getDisplayLocation().getWorld();
        if (world != null) {
            Location location = getDisplayLocation().add(new Vector(
                    ThreadLocalRandom.current().nextDouble(-getDisplayLocationOffset(), getDisplayLocationOffset()),
                    ThreadLocalRandom.current().nextDouble(-getDisplayLocationOffset(), getDisplayLocationOffset()),
                    ThreadLocalRandom.current().nextDouble(-getDisplayLocationOffset(), getDisplayLocationOffset())
            ));

            TextDisplay textDisplay = (TextDisplay) world.spawnEntity(location, EntityType.TEXT_DISPLAY);
            textDisplay.setText(getDisplayText());
            configureDisplay(textDisplay);

            PersistentDataContainer pdc = textDisplay.getPersistentDataContainer();
            pdc.set(KEY, PersistentDataType.BOOLEAN, true);

            new BukkitRunnable() {
                @Override
                public void run() {
                    textDisplay.remove();
                }
            }.runTaskLater(GenshinMinecraft.INSTANCE, getDisplayTicks());
        }
    }
}
