package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.gigaflop.alkahistorycraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AlkahistoryCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.CRYSTALFRAGMENTS.get())
                .add(Items.AMETHYST_SHARD);

        //<editor-fold desc="Crystal Tools">
        //vanilla tools
        tag(ItemTags.SWORDS).add(ModItems.CRYSTAL_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.CRYSTAL_PICKAXE.get());
        tag(ItemTags.AXES).add(ModItems.CRYSTAL_AXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.CRYSTAL_SHOVEL.get());
        tag(ItemTags.HOES).add(ModItems.CRYSTAL_HOE.get());
        //armor
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CRYSTAL_HELMET.get())
                .add(ModItems.CRYSTAL_CHESTPLATE.get())
                .add(ModItems.CRYSTAL_LEGGINGS.get())
                .add(ModItems.CRYSTAL_BOOTS.get());
        //</editor-fold>

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.CRYSTALFRAGMENTS.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.REGAL_SMITHING_TEMPLATE.get());

        tag(ItemTags.BOW_ENCHANTABLE).add(ModItems.REGAL_BOW.get());
    }
}
