package com.github.kirkkd.genshinminecraft.elemental.entities;

import com.github.kirkkd.genshinminecraft.GenshinMinecraft;
import com.github.kirkkd.genshinminecraft.elemental.elements.Cryo;
import com.github.kirkkd.genshinminecraft.elemental.elements.Hydro;
import com.github.kirkkd.genshinminecraft.elemental.elements.Pyro;
import com.github.kirkkd.genshinminecraft.elemental.items.infusions.ElementalInfusion;
import com.github.kirkkd.genshinminecraft.util.display.TemporaryTextDisplay;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ElementsEventListener implements Listener {
    private static final double ELEMENT_APPLICATION_RANGE = 50;

    public static void startTasks() {
        new BukkitRunnable() {
            @Override
            public void run() {
                checkElementApplication();
            }
        }.runTaskTimer(GenshinMinecraft.INSTANCE, 0, 5);
    }

    private static void checkElementApplication() {
        List<World> worlds = GenshinMinecraft.INSTANCE.getServer().getWorlds();
        List<LivingEntity> appliedEntities = new ArrayList<>();

        for (World world : worlds) {
            List<Player> players = world.getPlayers();
            for (Player player : players) {
                List<Entity> entities = player.getNearbyEntities(ELEMENT_APPLICATION_RANGE, ELEMENT_APPLICATION_RANGE, ELEMENT_APPLICATION_RANGE);
                for (Entity entity : entities) {
                    if (entity instanceof LivingEntity livingEntity && !appliedEntities.contains(livingEntity)) {
                        appliedEntities.add(livingEntity);
                        applyElements(livingEntity);
                    }
                }

                if (!appliedEntities.contains(player)) {
                    appliedEntities.add(player);
                    applyElements(player);
                }
            }
        }
    }

    private static void applyElements(LivingEntity livingEntity) {
        Material feetBlockType = livingEntity.getLocation().getBlock().getType();

        if (feetBlockType == Material.WATER) {
            ElementalEntity elementalEntity = ElementalEntity.createOrGet(livingEntity);
            if (elementalEntity != null) elementalEntity.applyElement(new Hydro(elementalEntity));
        } else if (feetBlockType == Material.POWDER_SNOW) {
            ElementalEntity elementalEntity = ElementalEntity.createOrGet(livingEntity);
            if (elementalEntity != null) elementalEntity.applyElement(new Cryo(elementalEntity));
        } else if (feetBlockType == Material.FIRE || feetBlockType == Material.LAVA || feetBlockType == Material.MAGMA_BLOCK) {
            ElementalEntity elementalEntity = ElementalEntity.createOrGet(livingEntity);
            if (elementalEntity != null) elementalEntity.applyElement(new Pyro(elementalEntity));
        }
    }

    @EventHandler
    public void onEntityCombust(EntityCombustEvent event) {
        if (event.getEntity() instanceof LivingEntity livingEntity) {
            if (TemporaryTextDisplay.isTemporaryTextDisplay(livingEntity)) {
                event.setCancelled(true);
                return;
            }

            ElementalEntity elementalEntity = ElementalEntity.createOrGet(livingEntity);
            if (elementalEntity != null) elementalEntity.applyElement(new Pyro(elementalEntity));
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player
                && event.getEntity() instanceof LivingEntity victim) {
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            if (heldItem.getAmount() != 0) {
                ElementalInfusion infusion = ElementalInfusion.fromItemStack(heldItem);
                if (infusion != null) infusion.onInfusionAffectEntity(player, victim);
            }
        }
    }
}
