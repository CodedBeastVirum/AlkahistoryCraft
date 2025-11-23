package net.gigaflop.alkahistorycraft.effect;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HeavyEffect extends MobEffect {
    public HeavyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onMobHurt(LivingEntity livingEntity, int amplifier, DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypeTags.IS_FALL)){
            livingEntity.invulnerableTime = 1;
            livingEntity.level().explode(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.5f * (amplifier +1), Level.ExplosionInteraction.MOB);
        }

        super.onMobHurt(livingEntity, amplifier, damageSource, amount);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
