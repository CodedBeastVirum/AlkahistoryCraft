package net.gigaflop.alkahistorycraft.item;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlkahistoryCraft.MODID);

    public static final Supplier<CreativeModeTab> ALKAHISTORY_CREATIVE_TAB = CREATIVE_MODE_TAB.register("alkahistory_items_tab",
            () -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.CRYSTALFRAGMENTS.get())).title(Component.translatable("creativetab.alkahistorycraft.alkahistory_items"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.CRYSTALFRAGMENTS);
                        output.accept(ModBlocks.CRYSTAL_SHARD_BLOCK);
                        output.accept(ModBlocks.CRYSTAL_SHARD_ORE);
                        output.accept(ModItems.CRYSTALCHISEL);
                        output.accept(ModBlocks.INFUSED_CRYSTAL_BLOCK);
                        output.accept(ModItems.JEWELEDAPPLE);
                        output.accept(ModItems.UNSTABLEFRAGMENT);
                        output.accept(ModItems.UNSTABLEDUST);
                        output.accept(ModBlocks.CRYSTAL_LAMP);
                        //<editor-fold desc="Dense Wood">
                        output.accept(ModBlocks.DENSE_WOOD_BLOCK);
                        output.accept(ModBlocks.DENSE_WOOD_STAIRS);
                        output.accept(ModBlocks.DENSE_WOOD_SLAB);
                        output.accept(ModBlocks.DENSE_WOOD_PRESSURE_PLATE);
                        output.accept(ModBlocks.DENSE_WOOD_BUTTON);
                        output.accept(ModBlocks.DENSE_WOOD_FENCE);
                        output.accept(ModBlocks.DENSE_WOOD_FENCE_GATE);
                        output.accept(ModBlocks.DENSE_WOOD_WALL);
                        output.accept(ModBlocks.DENSE_WOOD_DOOR);
                        output.accept(ModBlocks.DENSE_WOOD_TRAPDOOR);
                        //</editor-fold>
                        //<editor-fold desc="Crystal Tools">

                        //vanilla tools
                        output.accept(ModItems.CRYSTAL_SWORD);
                        output.accept(ModItems.CRYSTAL_PICKAXE);
                        output.accept(ModItems.CRYSTAL_AXE);
                        output.accept(ModItems.CRYSTAL_SHOVEL);
                        output.accept(ModItems.CRYSTAL_HOE);

                        //custom hammer tool
                        output.accept(ModItems.CRYSTAL_HAMMER);

                        //armors
                        output.accept(ModItems.CRYSTAL_HELMET);
                        output.accept(ModItems.CRYSTAL_CHESTPLATE);
                        output.accept(ModItems.CRYSTAL_LEGGINGS);
                        output.accept(ModItems.CRYSTAL_BOOTS);
                        //horse armor
                        output.accept(ModItems.CRYSTAL_HORSE_ARMOR);
                        //</editor-fold>
                        output.accept(ModItems.REGAL_SMITHING_TEMPLATE);
                        output.accept(ModItems.REGAL_BOW);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
