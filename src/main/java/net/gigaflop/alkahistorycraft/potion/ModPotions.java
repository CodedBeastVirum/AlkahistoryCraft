package net.gigaflop.alkahistorycraft.potion;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, AlkahistoryCraft.MODID);

    public static final Holder<Potion> SLIMY_POTION = POTIONS.register("slimy_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SLIMY_EFFECT, 1200, 0)));

    public static final Holder<Potion> HEAVY_POTION = POTIONS.register("heavy_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HEAVY_EFFECT, 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
