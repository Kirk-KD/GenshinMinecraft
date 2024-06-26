package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.IElemental;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.display.ElementTextDisplay;
import com.github.kirkkd.genshinminecraft.util.particles.EntityParticleSystem;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import com.github.kirkkd.genshinminecraft.util.display.ReactionTextDisplay;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.List;

public abstract class Element extends ElementTextDisplay implements IElemental {
    public static final List<String> ALL_NAMES = List.of("Anemo", "Geo", "Electro", "Dendro", "Hydro", "Cryo", "Pyro");

    private final ElementalEntity host;
    protected EntityParticleSystem entityParticleSystem = null;

    protected LivingEntity applier;

    public Element(ElementalEntity host) {
        this(host, null);
    }

    public Element(ElementalEntity host, LivingEntity applier) {
        this.host = host;
        this.applier = applier;
    }

    @Override
    public String getDisplayText() {
        return getVerb();
    }

    @Override
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

    public abstract void onApply();

    public abstract void onClear();

    public abstract void onTick();

    public Reaction getCombinationReaction(Element element) {
        if (element instanceof Anemo) return getCombinationReaction((Anemo) element);
        else if (element instanceof Geo) return getCombinationReaction((Geo) element);
        else if (element instanceof Electro) return getCombinationReaction((Electro) element);
        else if (element instanceof Dendro) return getCombinationReaction((Dendro) element);
        else if (element instanceof Hydro) return getCombinationReaction((Hydro) element);
        else if (element instanceof Cryo) return getCombinationReaction((Cryo) element);
        else if (element instanceof Pyro) return getCombinationReaction((Pyro) element);
        else return null;
    }

    protected abstract Reaction getCombinationReaction(Anemo anemo);

    protected abstract Reaction getCombinationReaction(Geo geo);

    protected abstract Reaction getCombinationReaction(Electro electro);

    protected abstract Reaction getCombinationReaction(Dendro dendro);

    protected abstract Reaction getCombinationReaction(Hydro hydro);

    protected abstract Reaction getCombinationReaction(Cryo cryo);

    protected abstract Reaction getCombinationReaction(Pyro pyro);

    public void spawnParticlesTick() {
        if (entityParticleSystem != null) {
            if (entityParticleSystem.isValid()) entityParticleSystem.onTick();
            else entityParticleSystem = null;
        }
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

    public EntityParticleSystem getEntityParticleSystem() {
        return entityParticleSystem;
    }
}
