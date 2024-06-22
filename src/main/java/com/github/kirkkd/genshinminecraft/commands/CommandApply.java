package com.github.kirkkd.genshinminecraft.commands;

import com.github.kirkkd.genshinminecraft.elemental.elements.*;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandApply implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) return false;

        if (commandSender instanceof Player player) {
            String elementName = strings[0].toLowerCase();

            ElementalEntity elementalEntity = ElementalEntity.createOrGet(player);
            if (elementalEntity == null) return false;

            switch (elementName) {
                case "anemo" -> elementalEntity.applyElement(new Anemo(elementalEntity));
                case "geo" -> elementalEntity.applyElement(new Geo(elementalEntity));
                case "electro" -> elementalEntity.applyElement(new Electro(elementalEntity));
                case "dendro" -> elementalEntity.applyElement(new Dendro(elementalEntity));
                case "hydro" -> elementalEntity.applyElement(new Hydro(elementalEntity));
                case "cryo" -> elementalEntity.applyElement(new Cryo(elementalEntity));
                case "pyro" -> elementalEntity.applyElement(new Pyro(elementalEntity));
                default -> {
                    return false;
                }
            }

            player.sendMessage("Applied " + elementName + " to yourself.");
            return true;
        }
        return false;
    }
}
