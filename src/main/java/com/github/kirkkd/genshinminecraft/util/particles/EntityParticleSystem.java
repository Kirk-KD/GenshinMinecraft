package com.github.kirkkd.genshinminecraft.util.particles;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public abstract class EntityParticleSystem extends ParticleSystem {
    protected Entity entity;

    public EntityParticleSystem(Entity entity) {
        super(entity.getLocation());
        this.entity = entity;
    }

    @Override
    public boolean isValid() {
        return this.entity.isValid();
    }

    @Override
    public Location getLocation() {
        return entity.getLocation();
    }
}
