package net.gigaflop.alkahistorycraft.item;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
