package net.gigaflop.alkahistorycraft.item;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.item.custom.CrystalChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //deffered register, this code tells minecraft to load the item list at the correct time
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AlkahistoryCraft.MODID);

    //item registration code
    public static final DeferredItem<Item> CRYSTALFRAGMENTS = ITEMS.register("crystalfragment",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRYSTALCHISEL = ITEMS.register("crystal_chisel",
            () -> new CrystalChiselItem(new Item.Properties().durability(256)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
