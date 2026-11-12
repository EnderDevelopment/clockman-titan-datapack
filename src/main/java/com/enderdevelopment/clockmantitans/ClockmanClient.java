package com.enderdevelopment.clockmantitans;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ClockmanClient implements ClientModInitializer {
    @Override public void onInitializeClient() {
        ScreenRegistry.register(ClockmanTitans.MENU_HANDLER, ClockmanScreen::new);
    }
}
