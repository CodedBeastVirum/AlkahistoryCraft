package net.gigaflop.alkahistorycraft.effect;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, AlkahistoryCraft.MODID);

    public static final Holder<MobEffect> SLIMY_EFFECT = MOB_EFFECTS.register("slimy",
            () -> new SlimyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,
                            "slimy"), -0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> HEAVY_EFFECT = MOB_EFFECTS.register("heavy",
            () -> new HeavyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID,
                            "heavy"), 2f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
