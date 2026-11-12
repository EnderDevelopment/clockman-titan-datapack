package com.enderdevelopment.clockmantitans;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class ClockmanScreen extends HandledScreen<ClockmanScreenHandler> {
    public ClockmanScreen(ClockmanScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        backgroundWidth = 300;
        backgroundHeight = 190;
    }

    @Override protected void init() {
        super.init();
        int left = x + 12;
        int right = x + 156;
        int top = y + 34;
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.clockman_titans.titan_1"), b -> press(0)).dimensions(left, top, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.clockman_titans.titan_2"), b -> press(1)).dimensions(right, top, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.literal("Time Blade"), b -> press(2)).dimensions(left, top + 26, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.literal("Giant Clock"), b -> press(3)).dimensions(right, top + 26, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.clockman_titans.time_stop"), b -> press(4)).dimensions(left, top + 70, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.clockman_titans.time_burst"), b -> press(5)).dimensions(right, top + 70, 132, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.translatable("screen.clockman_titans.rewind"), b -> press(6)).dimensions(left, top + 96, 276, 20).build());
    }

    private void press(int id) { if (client != null && client.interactionManager != null) client.interactionManager.clickButton(handler.syncId, id); }

    @Override protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.fill(x, y, x + backgroundWidth, y + backgroundHeight, 0xE0181C2B);
        context.fill(x + 8, y + 8, x + backgroundWidth - 8, y + 30, 0xFF263A59);
        context.drawText(textRenderer, title, x + 16, y + 16, 0xFFE8C45A, false);
        context.drawText(textRenderer, Text.translatable("screen.clockman_titans.equipment"), x + 12, y + 88, 0xFFB8D7FF, false);
        context.drawText(textRenderer, Text.translatable("screen.clockman_titans.powers"), x + 12, y + 128, 0xFFFFD36A, false);
    }

    @Override public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
