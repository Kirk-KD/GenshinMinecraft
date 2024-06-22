package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Cryo extends Element {
    public static final ChatColor COLOR = ChatColor.AQUA;
    public static final String NAME = "Cryo";

    public Cryo(ElementalEntity host) {
        this(host, null);
    }

    public Cryo(ElementalEntity host, LivingEntity applier) {
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
        return COLOR + "Chilled";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.CRYO;
    }
}
