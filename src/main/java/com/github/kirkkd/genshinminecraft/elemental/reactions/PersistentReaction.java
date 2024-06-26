package com.github.kirkkd.genshinminecraft.elemental.reactions;

import com.github.kirkkd.genshinminecraft.GenshinMinecraft;
import com.github.kirkkd.genshinminecraft.elemental.entities.ElementalEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class PersistentReaction extends Reaction {
    protected long duration = 1;
    protected long ticksInBetween = 1;

    protected BukkitTask reactionTask = null;
    protected BukkitTask cancellationTask = null;
    protected BukkitTask particlesTask = null;

    public PersistentReaction(ElementalEntity host) {
        this(host, null);
    }

    public PersistentReaction(ElementalEntity host, LivingEntity applier) {
        super(host, applier);
    }

    @Override
    public void onApply() {
        reactionTask = new BukkitRunnable() {
            @Override
            public void run() {
                onTick();
            }
        }.runTaskTimer(GenshinMinecraft.INSTANCE, 0, ticksInBetween);
        particlesTask = new BukkitRunnable() {
            @Override
            public void run() {
                spawnParticlesTick();
            }
        }.runTaskTimer(GenshinMinecraft.INSTANCE, 0, 1);
        cancellationTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (reactionTask != null) {
                    reactionTask.cancel();
                    reactionTask = null;
                }
                if (particlesTask != null) {
                    particlesTask.cancel();
                    particlesTask = null;
                }
                onClear();
            }
        }.runTaskLater(GenshinMinecraft.INSTANCE, duration);
    }

    @Override
    public void onClear() {
        if (reactionTask != null) {
            reactionTask.cancel();
            reactionTask = null;
        }
        if (particlesTask != null) {
            particlesTask.cancel();
            particlesTask = null;
        }
        if (cancellationTask != null) {
            cancellationTask.cancel();
            cancellationTask = null;
        }
    }

    protected abstract void onTick();
}
