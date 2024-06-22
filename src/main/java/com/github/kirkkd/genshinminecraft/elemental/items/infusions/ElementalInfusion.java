package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.GenshinMinecraft;
import com.github.kirkkd.genshinminecraft.elemental.elements.*;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ElementalInfusion {
    public static final NamespacedKey KEY = new NamespacedKey(GenshinMinecraft.INSTANCE, "INFUSION");

    protected ItemStack itemStack;

    public static ElementalInfusion fromItemStack(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) return null;
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        String elementName = pdc.get(KEY, PersistentDataType.STRING);

        if (elementName == null) return null;

        switch (elementName) {
            case (Anemo.NAME) -> {
                return new AnemoInfusion(itemStack);
            }
            case (Geo.NAME) -> {
                return new GeoInfusion(itemStack);
            }
            case (Electro.NAME) -> {
                return new ElectroInfusion(itemStack);
            }
            case (Dendro.NAME) -> {
                return new DendroInfusion(itemStack);
            }
            case (Hydro.NAME) -> {
                return new HydroInfusion(itemStack);
            }
            case (Cryo.NAME) -> {
                return new CryoInfusion(itemStack);
            }
            case (Pyro.NAME) -> {
                return new PyroInfusion(itemStack);
            }
            default -> {
                return null;
            }
        }
    }

    public static void infuseItemStack(ItemStack itemStack, String elementName) {
        if (!Element.ALL_NAMES.contains(elementName)) return;

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) return;

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(KEY, PersistentDataType.STRING, elementName);

        itemStack.setItemMeta(meta);

        Objects.requireNonNull(fromItemStack(itemStack)).applyLore();
    }

    public ElementalInfusion(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void applyLore() {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            List<String> lore = meta.getLore();
            lore = lore == null ? new ArrayList<>() : lore;

            String line = getInfusionLoreLine();
            if (!lore.contains(line)) {
                lore.add("");
                lore.add(line);
            }
            meta.setLore(lore);

            itemStack.setItemMeta(meta);
        }
    }

    public String getInfusionLoreLine() {
        return ChatColor.GRAY + "Infused with " + ChatColor.BOLD + getName();
    }

    public abstract String getName();

    public abstract void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim);
}
