package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Anemo extends Element {
    public static final ChatColor COLOR = ChatColor.DARK_AQUA;
    public static final String NAME = "Anemo";

    public Anemo(ElementalEntity host) {
        this(host, null);
    }

    public Anemo(ElementalEntity host, LivingEntity applier) {
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
        return COLOR + "Swayed";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.ANEMO;
    }
}
