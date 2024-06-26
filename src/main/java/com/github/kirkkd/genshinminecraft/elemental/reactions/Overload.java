package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.util.particles.reactions.OverloadEntityParticle;
import com.github.kirkkd.genshinminecraft.util.effects.NonDestructiveExplosion;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

public class Overload extends Reaction {
    public Overload(ElementalEntity host) {
        this(host, null);
    }

    public Overload(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
        entityParticleSystem = new OverloadEntityParticle(getHost().getEntity());
    }

    @Override
    public void onApply() {
        NonDestructiveExplosion explosion = new NonDestructiveExplosion(
                getHost().getEntity().getLocation().add(0, getHost().getEntity().getHeight() / 2d, 0),
                3, 5, getApplier());
        explosion.activate();

        World world = getHost().getEntity().getWorld();
        world.playSound(getHost().getEntity(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 1);
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
