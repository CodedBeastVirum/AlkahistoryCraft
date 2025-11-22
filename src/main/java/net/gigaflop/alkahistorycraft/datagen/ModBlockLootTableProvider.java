package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CRYSTAL_SHARD_BLOCK.get());
        dropSelf(ModBlocks.INFUSED_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.CRYSTAL_LAMP.get());
        //<editor-fold desc="Dense Wood">
        dropSelf(ModBlocks.DENSE_WOOD_BLOCK.get());
        dropSelf(ModBlocks.DENSE_WOOD_STAIRS.get());

        add(ModBlocks.DENSE_WOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DENSE_WOOD_SLAB.get()));

        dropSelf(ModBlocks.DENSE_WOOD_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DENSE_WOOD_BUTTON.get());
        dropSelf(ModBlocks.DENSE_WOOD_FENCE.get());
        dropSelf(ModBlocks.DENSE_WOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.DENSE_WOOD_WALL.get());
        dropSelf(ModBlocks.DENSE_WOOD_TRAPDOOR.get());


        add(ModBlocks.DENSE_WOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.DENSE_WOOD_DOOR.get()));

        //</editor-fold>
        add(ModBlocks.CRYSTAL_SHARD_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.CRYSTAL_SHARD_ORE.get(), ModItems.CRYSTALFRAGMENTS.get(), 1, 5)

                );
    }


    //function to add generic multi ore drops cause mojang are stupid
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    //get all blocks that were registered in modblocks, converting it to an iteratable.
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
