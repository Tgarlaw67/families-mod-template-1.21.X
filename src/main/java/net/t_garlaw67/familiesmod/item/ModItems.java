package net.t_garlaw67.familiesmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.t_garlaw67.familiesmod.FamiliesMod;

public class ModItems {
    public static final Item WEDDING_RING = registerItem("wedding_ring", new Item(new Item.Settings()));
    public static final Item MARRIAGE_LICENSE = registerItem("marriage_license", new Item(new Item.Settings()));
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FamiliesMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FamiliesMod.LOGGER.info("Registering Mod Items for" + FamiliesMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WEDDING_RING);
            entries.add(MARRIAGE_LICENSE);
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(DIAMOND_NUGGET);
        });
    }
}