package com.github.kirkkd.genshinminecraft.elemental.items.infusions;

import com.github.kirkkd.genshinminecraft.elemental.ElementalInfo;
import com.github.kirkkd.genshinminecraft.elemental.elements.Geo;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class GeoInfusion extends ElementalInfusion {
    public GeoInfusion(ItemStack itemStack) {
        super(itemStack);
    }

    @Override
    public ElementalInfo getElementalInfo() {
        return ElementalInfo.GEO;
    }

    @Override
    public void onInfusionAffectEntity(LivingEntity attacker, LivingEntity victim) {
        ElementalEntity victimEE = ElementalEntity.createOrGet(victim);
        if (victimEE != null) victimEE.applyElement(new Geo(victimEE, attacker));
    }
}
