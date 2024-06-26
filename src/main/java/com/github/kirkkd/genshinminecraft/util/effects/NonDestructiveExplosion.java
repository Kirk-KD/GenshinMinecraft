package com.github.kirkkd.genshinminecraft.util.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class NonDestructiveExplosion {
    private final Location location;
    private final double radius;
    private final double maxDamage;
    private final Entity ignoreEntity;

    public NonDestructiveExplosion(Location location, double radius, double maxDamage) {
        this(location, radius, maxDamage, null);
    }

    public NonDestructiveExplosion(Location location, double radius, double maxDamage, Entity ignoreEntity) {
        this.location = location;
        this.radius = radius;
        this.maxDamage = maxDamage;
        this.ignoreEntity = ignoreEntity;
    }

    public void activate() {
        spawnParticles();
        damageNearbyEntities();
    }

    private void spawnParticles() {
        World world = location.getWorld();
        if (world != null) world.spawnParticle(Particle.EXPLOSION, location, 1);
    }

    private void damageNearbyEntities() {
        World world = location.getWorld();
        if (world != null) {
            for (Entity entity : world.getNearbyEntities(location, radius * 2, radius * 2, radius * 2)
                         .stream()
                         .filter(entity -> entity instanceof LivingEntity && (ignoreEntity == null || entity != ignoreEntity))
                         .toList()) {
                double distance = entity.getLocation().distance(location);
                if (distance <= radius) {
                    double dmg = (1 - (distance / radius)) * maxDamage;
                    LivingEntity livingEntity = (LivingEntity) entity;
                    livingEntity.damage(dmg);
                }
            }
        }
    }
}
