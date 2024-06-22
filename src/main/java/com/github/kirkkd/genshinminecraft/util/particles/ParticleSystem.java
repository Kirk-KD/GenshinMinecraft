package com.github.kirkkd.genshinminecraft.util.particles;

import org.bukkit.Location;

public abstract class ParticleSystem {
    private final Location location;

    public ParticleSystem(Location location) {
        this.location = location;
    }

    public abstract void onTick();

    public abstract boolean isValid();

    public Location getLocation() {
        return location;
    }
}
