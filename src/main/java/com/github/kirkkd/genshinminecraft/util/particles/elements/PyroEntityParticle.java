package com.github.kirkkd.genshinminecraft.util.particles.elements;

import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class PyroEntityParticle extends EntityParticleSystem {
    public PyroEntityParticle(Entity entity) {
        super(entity);
    }

    @Override
    public void onTick() {
        Location location = getLocation();
        World world = location.getWorld();

        double height = entity.getHeight();
        double halfWidth = entity.getWidth() / 2d;

        if (world != null) {
            for (int i = 0; i < 2; i++) {
                Vector offset = new Vector(
                        ThreadLocalRandom.current().nextDouble(-halfWidth, halfWidth),
                        ThreadLocalRandom.current().nextDouble(0, height),
                        ThreadLocalRandom.current().nextDouble(-halfWidth, halfWidth)
                );
                world.spawnParticle(Particle.FLAME, location.clone().add(offset), 0, 0, 0, 0);
            }
        }
    }
}
