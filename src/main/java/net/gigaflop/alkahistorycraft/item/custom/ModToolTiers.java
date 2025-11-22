package net.gigaflop.alkahistorycraft.item.custom;

import net.gigaflop.alkahistorycraft.item.ModItems;
import net.gigaflop.alkahistorycraft.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CRYSTAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            5000, 6f, 5f, 50, () -> Ingredient.of(ModItems.CRYSTALFRAGMENTS));
}
