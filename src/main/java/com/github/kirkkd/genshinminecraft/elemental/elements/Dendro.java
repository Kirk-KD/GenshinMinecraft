package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Dendro extends Element {
    public static final ChatColor COLOR = ChatColor.DARK_GREEN;
    public static final String NAME = "Dendro";

    public Dendro(ElementalEntity host) {
        this(host, null);
    }

    public Dendro(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
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
        return null;
    }

    @Override
    public String getVerb() {
        return COLOR + "Rooted";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.DENDRO;
    }
}
