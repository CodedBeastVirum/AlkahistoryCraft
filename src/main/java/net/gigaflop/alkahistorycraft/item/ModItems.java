package net.gigaflop.alkahistorycraft.item;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.item.custom.CrystalChiselItem;
import net.gigaflop.alkahistorycraft.item.custom.FuelItem;
import net.gigaflop.alkahistorycraft.item.custom.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    //deffered register, this code tells minecraft to load the item list at the correct time
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AlkahistoryCraft.MODID);

    //item registration code
    public static final DeferredItem<Item> CRYSTALFRAGMENTS = ITEMS.register("crystalfragment",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRYSTALCHISEL = ITEMS.register("crystal_chisel",
            () -> new CrystalChiselItem(new Item.Properties().durability(256)));

    public static final DeferredItem<Item> JEWELEDAPPLE = ITEMS.register("jeweled_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.JEWELEDAPPLE)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.alkahistorycraft.jeweled_apple.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> UNSTABLEFRAGMENT = ITEMS.register("unstable_fragment",
            () -> new FuelItem(new Item.Properties(), 3200));

    public static final DeferredItem<Item> UNSTABLEDUST = ITEMS.register("unstable_dust",
            () -> new Item(new Item.Properties()));


    //<editor-fold desc="Crystal Tools">
    public static final DeferredItem<SwordItem> CRYSTAL_SWORD = ITEMS.register("crystal_sword",
            () -> new SwordItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CRYSTAL, 6, -2.5f))));

    public static final DeferredItem<PickaxeItem> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CRYSTAL, 1.0f, -2.8f))));

    public static final DeferredItem<ShovelItem> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel",
            () -> new ShovelItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CRYSTAL, 1.5f, -3f))));

    public static final DeferredItem<AxeItem> CRYSTAL_AXE = ITEMS.register("crystal_axe",
            () -> new AxeItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CRYSTAL, 7f, -3.2f))));

    public static final DeferredItem<HoeItem> CRYSTAL_HOE = ITEMS.register("crystal_hoe",
            () -> new HoeItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CRYSTAL, 0f, -3f))));
    //</editor-fold>

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
