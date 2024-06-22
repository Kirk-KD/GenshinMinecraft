package com.github.kirkkd.genshinminecraft.commands;

import com.github.kirkkd.genshinminecraft.elemental.elements.*;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import com.github.kirkkd.genshinminecraft.elemental.items.infusions.ElementalInfusion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandInfuse implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) return false;

        if (commandSender instanceof Player player) {
            String elementName = strings[0].toLowerCase();
            elementName = elementName.substring(0, 1).toUpperCase() + elementName.substring(1);
            if (!Element.ALL_NAMES.contains(elementName)) return false;

            ElementalEntity elementalEntity = ElementalEntity.createOrGet(player);
            if (elementalEntity == null) return false;

            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getAmount() == 0) return false;

            ElementalInfusion.infuseItemStack(itemStack, elementName);

            player.sendMessage("Infused " + elementName + " to the held item.");
            return true;
        }
        return false;
    }
}
