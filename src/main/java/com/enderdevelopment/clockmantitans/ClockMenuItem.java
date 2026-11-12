package com.enderdevelopment.clockmantitans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ClockMenuItem extends Item {
    public ClockMenuItem(Settings settings) { super(settings); }
    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) player.openHandledScreen(new ClockmanScreenHandler.Provider());
        return TypedActionResult.success(player.getStackInHand(hand), world.isClient);
    }
}
