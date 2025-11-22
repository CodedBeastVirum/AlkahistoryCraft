package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.gigaflop.alkahistorycraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AlkahistoryCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRYSTAL_SHARD_BLOCK.get())
                .add(ModBlocks.CRYSTAL_SHARD_ORE.get())
                .add(ModBlocks.INFUSED_CRYSTAL_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CRYSTAL_SHARD_BLOCK.get())
                .add(ModBlocks.INFUSED_CRYSTAL_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRYSTAL_SHARD_ORE.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.DENSE_WOOD_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.DENSE_WOOD_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.DENSE_WOOD_WALL.get());

        tag(ModTags.Blocks.NEEDS_CRYSTAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_CRYSTAL_TOOL);
    }
}
