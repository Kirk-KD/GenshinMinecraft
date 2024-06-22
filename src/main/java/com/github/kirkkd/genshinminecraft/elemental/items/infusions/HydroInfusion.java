package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.elements.Hydro;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class HydroInfusion extends ElementalInfusion {
    public HydroInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public String getName() {
        return Hydro.COLOR + Hydro.NAME;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Hydro(victimEE, attacker));
    }
}
