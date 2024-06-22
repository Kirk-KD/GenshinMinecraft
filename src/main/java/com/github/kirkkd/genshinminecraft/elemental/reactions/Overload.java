package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.reactions.OverloadEntityParticle;
import com.github.kirkkd.genshinminecraft.util.effects.NonDestructiveExplosion;
import org.bukkit.ChatColor;

public class Overload extends Reaction {
    public Overload(ElementalEntity host) {
        super(host);
        entityParticleSystem = new OverloadEntityParticle(getHost().getEntity());
    }

    @Override
    public void onApply() {
        NonDestructiveExplosion explosion = new NonDestructiveExplosion(
                getHost().getEntity().getLocation().add(0, getHost().getEntity().getHeight() / 2d, 0), 1, 1, 1);
        explosion.activate();
    }

    @Override
    public void onClear() {

    }

    @Override
    public String getVerb() {
        return ChatColor.RED + "Overload";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.OVERLOAD;
    }
}
