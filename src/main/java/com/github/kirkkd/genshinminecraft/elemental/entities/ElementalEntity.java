package com.github.kirkkd.genshinminecraft.elemental.entities;

import com.github.kirkkd.genshinminecraft.GenshinMinecraft;
import com.github.kirkkd.genshinminecraft.elemental.elements.Element;
import com.github.kirkkd.genshinminecraft.elemental.reactions.PersistentReaction;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import com.github.kirkkd.genshinminecraft.util.display.TemporaryTextDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class ElementalEntity {
    private static final int ELEMENT_TICKS = 10 * 20;

    private static final Map<LivingEntity, ElementalEntity> map = new HashMap<>();

    private final LivingEntity entity;
    private Element activeElement = null;
    private PersistentReaction activeReaction = null;

    private BukkitTask clearActiveElementTask = null;
    private BukkitTask tickActiveElementTask = null;

    public static ElementalEntity createOrGet(LivingEntity entity) {
        if (TemporaryTextDisplay.isTemporaryTextDisplay(entity)) return null;

        if (!map.containsKey(entity)) map.put(entity, new ElementalEntity(entity));

        if (!entity.isValid()) {
            map.remove(entity);
            return null;
        }

        return map.get(entity);
    }

    public ElementalEntity(LivingEntity entity) {
        this.entity = entity;
    }

    public void applyElement(Element element) {
        if (activeElement != null) {
            Reaction reaction = activeElement.getCombinationReaction(element);
            if (reaction != null) {
                applyReaction(reaction);
                return;
            }
        }

        // not the same element as the active one
        if (activeElement == null || !activeElement.getClass().equals(element.getClass())) {
            activeElement = element;
            activeElement.onApply();
            activeElement.summonTextDisplay();
        }

        // reset tasks
        cancelTasks();
        startTasks();
    }

    public void applyReaction(Reaction reaction) {
        clearElement();
        reaction.onApply();
        reaction.summonTextDisplay();

        if (reaction instanceof PersistentReaction persistentReaction) activeReaction = persistentReaction;
        else {
            reaction.spawnParticlesTick();
            reaction.onClear();
        }
    }

    public void clearElement() {
        cancelTasks();
        if (activeElement != null) {
            activeElement.onClear();
            activeElement = null;
        }
    }

    private void cancelTasks() {
        if (tickActiveElementTask != null) {
            tickActiveElementTask.cancel();
            tickActiveElementTask = null;
        }
        if (clearActiveElementTask != null) {
            clearActiveElementTask.cancel();
            clearActiveElementTask = null;
        }
    }

    private void startTasks() {
        tickActiveElementTask = new BukkitRunnable() {
            @Override
            public void run() {
                activeElement.spawnParticlesTick();
                activeElement.onTick();
            }
        }.runTaskTimer(GenshinMinecraft.INSTANCE, 0, 1);
        clearActiveElementTask = new BukkitRunnable() {
            @Override
            public void run() {
                clearElement();
            }
        }.runTaskLater(GenshinMinecraft.INSTANCE, ELEMENT_TICKS);
    }

    public LivingEntity getEntity() {
        return entity;
    }
}
