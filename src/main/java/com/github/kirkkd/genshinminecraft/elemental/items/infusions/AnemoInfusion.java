package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.elements.Anemo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class AnemoInfusion extends ElementalInfusion {
    public AnemoInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public String getName() {
        return Anemo.COLOR + Anemo.NAME;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Anemo(victimEE, attacker));
    }
}
