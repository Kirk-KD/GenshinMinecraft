package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.IElemental;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.display.ReactionTextDisplay;
import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public abstract class Reaction extends ReactionTextDisplay implements IElemental {
    private final ElementalEntity host;
    private final LivingEntity applier;
    protected EntityParticleSystem entityParticleSystem = null;

    public Reaction(ElementalEntity host) {
        this(host, null);
    }

    public Reaction(ElementalEntity host, LivingEntity applier) {
        this.host = host;
        this.applier = applier;
    }

    public void spawnParticlesTick() {
        if (entityParticleSystem != null) {
            if (entityParticleSystem.isValid()) entityParticleSystem.onTick();
            else entityParticleSystem = null;
        }
    }

    public abstract void onApply();

    public void onClear() {
        spawnParticlesTick();
    }

    public abstract String getVerb();

    @Override
    public ElementalEntity getHost() {
        return host;
    }

    @Override
    public LivingEntity getApplier() {
        return applier;
    }

    public String getDisplayText() {
        return getVerb();
    }

    public long getDisplayTicks() {
        return (long) (20 * 2.5);
    }

    @Override
    public Location getDisplayLocation() {
        return getHost().getEntity().getLocation().add(new Vector(
                0, getHost().getEntity().getHeight() / 2d, 0
        ));
    }

    @Override
    public double getDisplayLocationOffset() {
        return getHost().getEntity().getHeight() / 3d;
    }
}
