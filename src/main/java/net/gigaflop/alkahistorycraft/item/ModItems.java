package net.gigaflop.alkahistorycraft.item;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.item.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
    //vanilla tools
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


    //custom hammer tool
    public static final DeferredItem<HammerItem> CRYSTAL_HAMMER = ITEMS.register("crystal_hammer",
            () -> new HammerItem(ModToolTiers.CRYSTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CRYSTAL, 7f, -3.5f))));


    //armors
    public static final DeferredItem<ArmorItem> CRYSTAL_HELMET = ITEMS.register("crystal_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));

    public static final DeferredItem<ArmorItem> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));

    public static final DeferredItem<ArmorItem> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));

    public static final DeferredItem<ArmorItem> CRYSTAL_BOOTS = ITEMS.register("crystal_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    //horse armor
    public static final DeferredItem<Item> CRYSTAL_HORSE_ARMOR = ITEMS.register("crystal_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.CRYSTAL_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN, false,
                    new Item.Properties().stacksTo(1)));

    //</editor-fold>

    //<editor-fold desc="Regal Items">
    public static final DeferredItem<Item> REGAL_SMITHING_TEMPLATE = ITEMS.register("regal_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, "regal")));

    public static final DeferredItem<Item> REGAL_BOW = ITEMS.register("regal_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    //</editor-fold>

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
