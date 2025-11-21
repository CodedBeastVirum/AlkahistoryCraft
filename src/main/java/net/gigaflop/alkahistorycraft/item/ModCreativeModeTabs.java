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
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
