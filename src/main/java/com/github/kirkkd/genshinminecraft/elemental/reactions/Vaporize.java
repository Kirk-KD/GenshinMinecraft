package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.reactions.VaporizeEntityParticle;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;

public class Vaporize extends Reaction {
    public Vaporize(ElementalEntity host) {
        super(host);
        entityParticleSystem = new VaporizeEntityParticle(host.getEntity());
    }

    @Override
    public void onApply() {
        World world = getHost().getEntity().getWorld();
        world.playSound(getHost().getEntity(), Sound.BLOCK_FIRE_EXTINGUISH, 0.5f, 2);
    }

    @Override
    public void onClear() {

    }

    @Override
    public String getVerb() {
        return ChatColor.GOLD + "Vaporize";
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.VAPORIZE;
    }
}
