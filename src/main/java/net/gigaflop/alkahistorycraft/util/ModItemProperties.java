package net.gigaflop.alkahistorycraft.util;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.component.ModDataComponents;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CRYSTALCHISEL.get(), ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);
    }
}
