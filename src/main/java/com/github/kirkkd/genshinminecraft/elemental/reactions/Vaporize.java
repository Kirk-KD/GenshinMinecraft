package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.reactions.VaporizeEntityParticle;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vaporize extends Reaction {
    public Vaporize(ElementalEntity host) {
        this(host, null);
    }

    public Vaporize(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
        entityParticleSystem = new VaporizeEntityParticle(host.getEntity());
    }

    @Override
    public void onApply() {
        World world = getHost().getEntity().getWorld();
        world.playSound(getHost().getEntity(), Sound.BLOCK_FIRE_EXTINGUISH, 0.5f, 2);
        getHost().getEntity().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3 * 20, 0, true));
        if (getApplier() != null) getApplier().addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 2 * 20, 0, true));
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
