package com.github.kirkkd.genshinminecraft.util.particles.reactions;

import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class VaporizeEntityParticle extends EntityParticleSystem {
    public VaporizeEntityParticle(Entity entity) {
        super(entity);
    }

    @Override
    public void onTick() {
        Location location = getLocation();
        World world = location.getWorld();

        if (world != null) {
            double halfWidth = entity.getWidth() / 2d;
            double height = entity.getHeight();

            for (int i = 0; i < 30; i++) {
                Vector offset = new Vector(
                        ThreadLocalRandom.current().nextDouble(-halfWidth, halfWidth),
                        ThreadLocalRandom.current().nextDouble(0, height),
                        ThreadLocalRandom.current().nextDouble(-halfWidth, halfWidth)
                );
                double velX = ThreadLocalRandom.current().nextDouble(-0.2, 0.2);
                double velY = ThreadLocalRandom.current().nextDouble(0.2, 0.3);
                double velZ = ThreadLocalRandom.current().nextDouble(-0.2, 0.2);
                world.spawnParticle(Particle.CLOUD, location.clone().add(offset), 0, velX, velY, velZ);
            }
        }
    }
}
