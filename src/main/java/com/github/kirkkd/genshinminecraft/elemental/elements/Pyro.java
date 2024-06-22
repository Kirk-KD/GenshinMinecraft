package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.elements.PyroEntityParticle;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Overload;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Vaporize;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Pyro extends Element {
    public static final ChatColor COLOR = ChatColor.GOLD;
    public static final String NAME = "Pyro";

    public Pyro(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
        entityParticleSystem = new PyroEntityParticle(host.getEntity());
    }

    public Pyro(ElementalEntity host) {
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
        return new Overload(getHost());
    }

    @Override
    protected Reaction getCombinationReaction(Dendro dendro) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Hydro hydro) {
        return new Vaporize(getHost());
    }

    @Override
    protected Reaction getCombinationReaction(Cryo cryo) {
        return null;
    }

    @Override
    protected Reaction getCombinationReaction(Pyro pyro) {
        return null;
    }

    @Override
    public String getVerb() {
        return COLOR + "Heated";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.PYRO;
    }
}
