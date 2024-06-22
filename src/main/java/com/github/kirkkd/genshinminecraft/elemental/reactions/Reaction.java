package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.IElemental;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.display.ReactionTextDisplay;
import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import com.github.kirkkd.genshinminecraft.util.display.TemporaryTextDisplay;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public abstract class Reaction extends ReactionTextDisplay implements IElemental {
    private final ElementalEntity host;
    protected EntityParticleSystem entityParticleSystem = null;

    public Reaction(ElementalEntity host) {
        this.host = host;
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

    public ElementalEntity getHost() {
        return host;
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
