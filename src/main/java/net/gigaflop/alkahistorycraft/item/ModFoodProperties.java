package net.gigaflop.alkahistorycraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties JEWELEDAPPLE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).
            alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400, 4), 1f).build();

    public static final FoodProperties GOJI_BERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).
            alwaysEdible().fast().build();
}
