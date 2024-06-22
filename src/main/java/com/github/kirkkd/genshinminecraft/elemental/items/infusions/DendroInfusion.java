package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.elements.Dendro;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class DendroInfusion extends ElementalInfusion {
    public DendroInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public String getName() {
        return Dendro.COLOR + Dendro.NAME;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Dendro(victimEE, attacker));
    }
}
