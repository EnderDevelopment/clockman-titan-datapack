package com.enderdevelopment.clockmantitans;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public final class ClockmanPowers {
    private static final Map<UUID, Long> COOLDOWNS = new ConcurrentHashMap<>();
    private static final int COOLDOWN_TICKS = 20 * 20;
    private ClockmanPowers() { }

    public static void activate(PlayerEntity player, int power) {
        World world = player.getWorld();
        if (world.isClient || !(player instanceof ServerPlayerEntity serverPlayer)) return;
        long now = world.getTime();
        if (COOLDOWNS.getOrDefault(player.getUuid(), 0L) > now) {
            player.sendMessage(Text.translatable("screen.clockman_titans.cooldown"), true);
            return;
        }
        COOLDOWNS.put(player.getUuid(), now + COOLDOWN_TICKS);
        ServerWorld serverWorld = (ServerWorld) world;
        switch (power) {
            case 0 -> {
                Box area = player.getBoundingBox().expand(10);
                for (LivingEntity target : serverWorld.getEntitiesByClass(LivingEntity.class, area, entity -> entity != player)) {
                    target.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SLOWNESS, 100, 6));
                    target.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.GLOWING, 100, 0));
                }
                serverWorld.spawnParticles(ParticleTypes.ELECTRIC_SPARK, player.getX(), player.getY() + 1, player.getZ(), 80, 4, 2, 4, 0.08);
            }
            case 1 -> {
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED, 300, 2));
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.STRENGTH, 300, 1));
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.RESISTANCE, 300, 1));
                serverWorld.spawnParticles(ParticleTypes.CRIT, player.getX(), player.getY() + 1, player.getZ(), 50, 1, 1, 1, 0.2);
            }
            case 2 -> {
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.ABSORPTION, 400, 3));
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.RESISTANCE, 160, 3));
                player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.REGENERATION, 160, 1));
            }
            default -> { return; }
        }
        serverWorld.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 1.0f, 0.7f + power * 0.2f);
        serverPlayer.sendMessage(Text.literal("Clockman power activated"), true);
    }
}
