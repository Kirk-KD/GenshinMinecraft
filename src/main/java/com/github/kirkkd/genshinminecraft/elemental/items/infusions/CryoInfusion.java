package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.elements.Cryo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class CryoInfusion extends ElementalInfusion {
    public CryoInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public String getName() {
        return Cryo.COLOR + Cryo.NAME;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Cryo(victimEE, attacker));
    }
}
