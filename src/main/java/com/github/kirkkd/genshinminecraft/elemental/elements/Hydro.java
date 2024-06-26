package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.elements.HydroEntityParticle;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Vaporize;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Hydro extends Element {
    public static final ChatColor COLOR = ChatColor.BLUE;
    public static final String NAME = "Hydro";

    public Hydro(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
        entityParticleSystem = new HydroEntityParticle(host.getEntity());
    }

    public Hydro(ElementalEntity host) {
        this(host, null);
    }

    @Override
    public void onApply() {

    }

    @Override
    public void onClear() {

    }

    @Override
    public void onTick() {

    }

    @Override
    protected Reaction getCombinationReaction(Anemo anemo) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Geo geo) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Electro electro) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Dendro dendro) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Hydro hydro) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Cryo cryo) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Pyro pyro) {
        return new Vaporize(getHost(), getApplier());
    }

    @Override
    public String getVerb() {
        return COLOR + "Wet";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.HYDRO;
    }
}
