package com.github.kirkkd.genshinminecraft;

import com.github.kirkkd.genshinminecraft.commands.CommandApply;
import com.github.kirkkd.genshinminecraft.commands.CommandInfuse;
import com.github.kirkkd.genshinminecraft.commands.TabApply;
import com.github.kirkkd.genshinminecraft.commands.TabInfuse;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementsEventListener;
import com.github.kirkkd.genshinminecraft.util.display.TemporaryTextDisplay;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GenshinMinecraft extends JavaPlugin {
    public static GenshinMinecraft INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        cleanup();

        registerEventListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
    }

    private void cleanup() {
        TemporaryTextDisplay.removeAllDisplays();
    }

    private void registerEventListeners() {
        ElementsEventListener.startTasks();
        getServer().getPluginManager().registerEvents(new ElementsEventListener(), this);
    }

    private void registerCommands() {
        PluginCommand commandApply = Objects.requireNonNull(getCommand("apply"));
        commandApply.setExecutor(new CommandApply());
        commandApply.setTabCompleter(new TabApply());

        PluginCommand commandInfuse = Objects.requireNonNull(getCommand("infuse"));
        commandInfuse.setExecutor(new CommandInfuse());
        commandInfuse.setTabCompleter(new TabInfuse());
    }
}
