package com.enderdevelopment.clockmantitans;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class ClockmanScreenHandler extends ScreenHandler {
    private final PlayerEntity player;

    public ClockmanScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf data) {
        super(ClockmanTitans.MENU_HANDLER, syncId);
        this.player = inventory.player;
    }

    @Override public ItemStack quickMove(PlayerEntity player, int slot) { return ItemStack.EMPTY; }
    @Override public boolean canUse(PlayerEntity player) { return true; }

    @Override public boolean onButtonClick(PlayerEntity player, int id) {
        if (player.getWorld().isClient || player != this.player || id < 0 || id > 6) return false;
        switch (id) {
            case 0 -> give(ClockmanTitans.TITAN_1_CORE);
            case 1 -> give(ClockmanTitans.TITAN_2_CORE);
            case 2 -> give(ClockmanTitans.TIME_BLADE);
            case 3 -> give(ClockmanTitans.GIANT_CLOCK);
            case 4 -> ClockmanPowers.activate(player, 0);
            case 5 -> ClockmanPowers.activate(player, 1);
            case 6 -> ClockmanPowers.activate(player, 2);
            default -> { return false; }
        }
        return true;
    }

    private void give(net.minecraft.item.Item item) {
        ItemStack stack = new ItemStack(item);
        if (!player.getInventory().insertStack(stack)) player.dropItem(stack, false);
    }

    public static class Provider implements NamedScreenHandlerFactory {
        @Override public Text getDisplayName() { return Text.translatable("screen.clockman_titans.menu"); }
        @Override public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
            return new ClockmanScreenHandler(syncId, inventory, null);
        }
    }
}
