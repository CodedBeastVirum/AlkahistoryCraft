package net.gigaflop.alkahistorycraft.enchantment;

import com.mojang.serialization.MapCodec;
import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.enchantment.custom.ZappingEnchantmentEffect;
import net.minecraft.advancements.critereon.LightningStrikeTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, AlkahistoryCraft.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> ZAPPING =
            ENTITY_ENCHANTMENT_EFFECTS.register("zapper", () -> ZappingEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
