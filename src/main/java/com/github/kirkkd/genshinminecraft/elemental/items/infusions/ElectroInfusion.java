package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.elements.Electro;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class ElectroInfusion extends ElementalInfusion {
    public ElectroInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public String getName() {
        return Electro.COLOR + Electro.NAME;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Electro(victimEE, attacker));
    }
}
