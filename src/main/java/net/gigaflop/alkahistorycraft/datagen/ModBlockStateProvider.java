package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlkahistoryCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRYSTAL_SHARD_BLOCK);
        blockWithItem(ModBlocks.INFUSED_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_SHARD_ORE);
        //<editor-fold desc="Dense Wood">
        blockWithItem(ModBlocks.DENSE_WOOD_BLOCK);

        stairsBlock(ModBlocks.DENSE_WOOD_STAIRS.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));
        slabBlock(ModBlocks.DENSE_WOOD_SLAB.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));

        buttonBlock(ModBlocks.DENSE_WOOD_BUTTON.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));
        pressurePlateBlock(ModBlocks.DENSE_WOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));

        fenceBlock(ModBlocks.DENSE_WOOD_FENCE.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));
        fenceGateBlock(ModBlocks.DENSE_WOOD_FENCE_GATE.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));
        wallBlock(ModBlocks.DENSE_WOOD_WALL.get(), blockTexture(ModBlocks.DENSE_WOOD_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.DENSE_WOOD_DOOR.get(), modLoc("block/dense_wood_door_bottom"), modLoc("block/dense_wood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.DENSE_WOOD_TRAPDOOR.get(), modLoc("block/dense_wood_trapdoor"), true, "cutout");

        blockItem(ModBlocks.DENSE_WOOD_STAIRS);
        blockItem(ModBlocks.DENSE_WOOD_SLAB);
        blockItem(ModBlocks.DENSE_WOOD_PRESSURE_PLATE);
        blockItem(ModBlocks.DENSE_WOOD_FENCE_GATE);
        blockItem(ModBlocks.DENSE_WOOD_TRAPDOOR, "_bottom");
        //</editor-fold>
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("alkahistorycraft:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("alkahistorycraft:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
