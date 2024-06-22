package com.github.kirkkd.genshinminecraft.util.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

public class NonDestructiveExplosion {
    private Location location;
    private double radius;
    private double maxDamage;
    private double minDamage;

    public NonDestructiveExplosion(Location location, double radius, double maxDamage, double minDamage) {
        this.location = location;
        this.radius = radius;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
    }

    public void activate() {
        World world = location.getWorld();
        if (world != null) world.spawnParticle(Particle.EXPLOSION, location, 1);
    }
}
