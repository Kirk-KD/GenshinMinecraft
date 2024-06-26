package com.github.kirkkd.genshinminecraft.elemental;

import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;

/**
 * The {@code IElemental} interface represents any elemental objects (mainly elements and reactions).
 */
public interface IElemental {
    ElementalInfo getElementalInfo();

    LivingEntity getApplier();

    ElementalEntity getHost();
}
