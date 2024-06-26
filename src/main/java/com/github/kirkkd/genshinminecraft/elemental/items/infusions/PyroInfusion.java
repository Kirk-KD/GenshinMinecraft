package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.elements.Pyro;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class PyroInfusion extends ElementalInfusion {
    public PyroInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.PYRO;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Pyro(victimEE, attacker));
    }
}
