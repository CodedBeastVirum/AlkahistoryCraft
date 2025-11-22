package net.gigaflop.alkahistorycraft.util;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_CRYSTAL_TOOL = createTag("needs_bismuth_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRYSTAL_TOOL = createTag("incorrect_for_crystal_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, name));
        }
    }
}
