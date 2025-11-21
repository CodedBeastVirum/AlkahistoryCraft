package net.gigaflop.alkahistorycraft.block.custom;

import net.gigaflop.alkahistorycraft.item.ModItems;
import net.gigaflop.alkahistorycraft.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class InfusedCrystalBlock extends Block {
    public InfusedCrystalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1f, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
                level.playSound(entity, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 1f);
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.alkahistorycraft.infused_crystal_block.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
