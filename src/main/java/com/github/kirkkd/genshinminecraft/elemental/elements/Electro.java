package com.github.kirkkd.genshinminecraft.elemental.elements;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Overload;
import com.github.kirkkd.genshinminecraft.elemental.reactions.Reaction;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Electro extends Element {
    public static final ChatColor COLOR = ChatColor.LIGHT_PURPLE;
    public static final String NAME = "Electro";

    public Electro(ElementalEntity host) {
        this(host, null);
    }

    public Electro(ElementalEntity host, LivingEntity applier) {
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
        return new Overload(getHost());
    }

    @Override
    public String getVerb() {
        return COLOR + "Stunned";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.ELECTRO;
    }
}
