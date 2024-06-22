package com.github.kirkkd.genshinminecraft.util.particles.reactions;

import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class OverloadEntityParticle extends EntityParticleSystem {
    public OverloadEntityParticle(Entity entity) {
        super(entity);
    }

    @Override
    public void onTick() {
        Location location = entity.getLocation().clone().add(0, entity.getHeight() / 2d, 0);
        World world = entity.getWorld();
        world.spawnParticle(Particle.WAX_ON, location, 30, 1, 1, 1);

        double halfSize = 2;
        for (int i = 0; i < 50; i++) {
            Vector offset = new Vector(
                    ThreadLocalRandom.current().nextDouble(-halfSize, halfSize),
                    ThreadLocalRandom.current().nextDouble(-halfSize, halfSize),
                    ThreadLocalRandom.current().nextDouble(-halfSize, halfSize)
            );
            world.spawnParticle(Particle.WITCH, location.clone().add(offset), 0, 0, 0, 0);
        }
    }
}
