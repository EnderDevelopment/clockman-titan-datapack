package com.enderdevelopment.clockmantitans;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ClockmanTitans implements ModInitializer {
    public static final String MOD_ID = "clockman_titans";
    public static final Item CLOCK_MENU = register("clock_menu", new ClockMenuItem(new Item.Settings().maxCount(1)));
    public static final Item TITAN_1_CORE = register("titan_1_core", new Item(new Item.Settings().maxCount(1)));
    public static final Item TITAN_2_CORE = register("titan_2_core", new Item(new Item.Settings().maxCount(1)));
    public static final Item TIME_BLADE = register("time_blade", new Item(new Item.Settings().maxCount(1)));
    public static final Item GIANT_CLOCK = register("giant_clock", new Item(new Item.Settings().maxCount(1)));
    public static final ScreenHandlerType<ClockmanScreenHandler> MENU_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER, id("menu"), new ScreenHandlerType<>(ClockmanScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    private static Item register(String name, Item item) { return Registry.register(Registries.ITEM, id(name), item); }
    public static Identifier id(String name) { return Identifier.of(MOD_ID, name); }

    @Override public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CLOCK_MENU);
            entries.add(TITAN_1_CORE);
            entries.add(TITAN_2_CORE);
            entries.add(TIME_BLADE);
            entries.add(GIANT_CLOCK);
        });
    }
}
