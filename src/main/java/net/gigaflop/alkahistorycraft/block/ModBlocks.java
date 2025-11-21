package net.gigaflop.alkahistorycraft.block;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.custom.InfusedCrystalBlock;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    //deferred register for block setup
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AlkahistoryCraft.MODID);

    public static final DeferredBlock<Block> CRYSTAL_SHARD_BLOCK = registerBlock("crystal_shard_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CRYSTAL_SHARD_ORE = registerBlock("crystal_shard_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> INFUSED_CRYSTAL_BLOCK = registerBlock("infused_crystal_block",
            () -> new InfusedCrystalBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //actual block registration
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        //setup a variable for your block to be added to the deferred register list
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        //use the register block item function below to register an item for said block using the set up block above
        registerBlockItem(name, toReturn);
        //return the block to register so it can be added to the list
        return toReturn;
    }

    //helper method to register a block along with its related item
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
