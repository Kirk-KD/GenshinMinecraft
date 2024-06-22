package com.github.kirkkd.genshinminecraft.util.particles.elements;

import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class HydroEntityParticle extends EntityParticleSystem {
    public HydroEntityParticle(Entity entity) {
        super(entity);
    }

    @Override
    public void onTick() {
        Location locationBottom = getLocation();
        Location location = locationBottom.add(new Vector(0, entity.getHeight() / 3f, 0));

        World world = locationBottom.getWorld();

        if (world != null) {
            world.spawnParticle(Particle.FALLING_WATER, location, 10, entity.getWidth() / 4, entity.getHeight() / 4, entity.getWidth() / 4);
        }
    }
}
