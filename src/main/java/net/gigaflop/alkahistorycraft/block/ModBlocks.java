package net.gigaflop.alkahistorycraft.block;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.custom.CrystalLamp;
import net.gigaflop.alkahistorycraft.block.custom.GojiBerryBushBlock;
import net.gigaflop.alkahistorycraft.block.custom.InfusedCrystalBlock;
import net.gigaflop.alkahistorycraft.block.custom.RadishCropBlock;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.gigaflop.alkahistorycraft.sound.ModSounds;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    //deferred register for block setup
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AlkahistoryCraft.MODID);

    public static final DeferredBlock<Block> CRYSTAL_SHARD_BLOCK = registerBlock("crystal_shard_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(ModSounds.CRYSTAL_BLOCK_SOUNDS)));

    public static final DeferredBlock<Block> CRYSTAL_SHARD_ORE = registerBlock("crystal_shard_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> INFUSED_CRYSTAL_BLOCK = registerBlock("infused_crystal_block",
            () -> new InfusedCrystalBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(ModSounds.CRYSTAL_BLOCK_SOUNDS)));

    //<editor-fold desc="Dense Wood">
    public static final DeferredBlock<Block> DENSE_WOOD_BLOCK = registerBlock("dense_wood_planks",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<StairBlock> DENSE_WOOD_STAIRS = registerBlock("dense_wood_stairs",
            () -> new StairBlock(ModBlocks.DENSE_WOOD_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<SlabBlock> DENSE_WOOD_SLAB = registerBlock("dense_wood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<PressurePlateBlock> DENSE_WOOD_PRESSURE_PLATE = registerBlock("dense_wood_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<ButtonBlock> DENSE_WOOD_BUTTON = registerBlock("dense_wood_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).noCollission().sound(SoundType.WOOD)));

    public static final DeferredBlock<FenceBlock> DENSE_WOOD_FENCE = registerBlock("dense_wood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<FenceGateBlock> DENSE_WOOD_FENCE_GATE = registerBlock("dense_wood_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<WallBlock> DENSE_WOOD_WALL = registerBlock("dense_wood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final DeferredBlock<DoorBlock> DENSE_WOOD_DOOR = registerBlock("dense_wood_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> DENSE_WOOD_TRAPDOOR = registerBlock("dense_wood_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD).noOcclusion()));
    //</editor-fold>

    public static final DeferredBlock<Block> CRYSTAL_LAMP = registerBlock("crystal_lamp",
            () -> new CrystalLamp(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                            .lightLevel(state -> state.getValue(CrystalLamp.CLICKED) ? 15 : 0).sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RADISH_CROP = BLOCKS.register("radish_crop",
            () -> new RadishCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS).noOcclusion()));

    public static final DeferredBlock<Block> GOJI_BERRY_BUSH = BLOCKS.register("goji_berry_bush",
            () -> new GojiBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).noOcclusion()));



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
