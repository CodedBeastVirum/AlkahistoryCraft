package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AlkahistoryCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CRYSTALFRAGMENTS.get());
        basicItem(ModItems.JEWELEDAPPLE.get());
        basicItem(ModItems.CRYSTALCHISEL.get());
        basicItem(ModItems.UNSTABLEDUST.get());
        basicItem(ModItems.UNSTABLEFRAGMENT.get());

        buttonItem(ModBlocks.DENSE_WOOD_BUTTON, ModBlocks.DENSE_WOOD_BLOCK);
        fenceItem(ModBlocks.DENSE_WOOD_FENCE, ModBlocks.DENSE_WOOD_BLOCK);
        wallItem(ModBlocks.DENSE_WOOD_WALL, ModBlocks.DENSE_WOOD_BLOCK);

        basicItem(ModBlocks.DENSE_WOOD_DOOR.asItem());

        //<editor-fold desc="Crystal Tools">
        handheldItem(ModItems.CRYSTAL_SWORD);
        handheldItem(ModItems.CRYSTAL_PICKAXE);
        handheldItem(ModItems.CRYSTAL_AXE);
        handheldItem(ModItems.CRYSTAL_SHOVEL);
        handheldItem(ModItems.CRYSTAL_HOE);
        handheldItem(ModItems.CRYSTAL_HAMMER);
        //</editor-fold>
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,"item/" + item.getId().getPath()));
    }
}
