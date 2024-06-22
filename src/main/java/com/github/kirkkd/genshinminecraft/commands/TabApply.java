package com.github.kirkkd.genshinminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class TabApply implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) return List.of("anemo", "geo", "electro", "dendro", "hydro", "cryo", "pyro");
        return null;
    }
}
