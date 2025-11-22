package net.gigaflop.alkahistorycraft.datagen;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.gigaflop.alkahistorycraft.block.ModBlocks;
import net.gigaflop.alkahistorycraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> CRYSTAL_SMELTABLES = List.of(ModItems.UNSTABLEFRAGMENT, ModBlocks.CRYSTAL_SHARD_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRYSTAL_SHARD_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_frag_to_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CRYSTALCHISEL.get())
                .pattern("  C")
                .pattern(" S ")
                .pattern("S  ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput, "alkahistorycraft:craftcrystalchisel");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JEWELEDAPPLE.get())
                .pattern("CCC")
                .pattern("CAC")
                .pattern("CCC")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput, "alkahistorycraft:craftjeweledapple");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRYSTALFRAGMENTS.get(), 9)
                .requires(ModBlocks.CRYSTAL_SHARD_BLOCK.get())
                .unlockedBy("has_CrystalShardBlock", has(ModBlocks.CRYSTAL_SHARD_BLOCK)).save(recipeOutput,"alkahistorycraft:crystal_block_to_frag");

        oreSmelting(recipeOutput, CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.CRYSTALFRAGMENTS.get(), 0.25f, 200, "crystal");
        oreBlasting(recipeOutput, CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.CRYSTALFRAGMENTS.get(), 0.25f, 200, "crystal");

        //<editor-fold desc="Dense Wood">
        stairBuilder(ModBlocks.DENSE_WOOD_STAIRS.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        buttonBuilder(ModBlocks.DENSE_WOOD_BUTTON.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        fenceBuilder(ModBlocks.DENSE_WOOD_FENCE.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        fenceGateBuilder(ModBlocks.DENSE_WOOD_FENCE_GATE.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        doorBuilder(ModBlocks.DENSE_WOOD_DOOR.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.DENSE_WOOD_TRAPDOOR.get(), Ingredient.of(ModBlocks.DENSE_WOOD_BLOCK)).group("Dense Wood")
                .unlockedBy("has_DenseWood", has(ModBlocks.DENSE_WOOD_BLOCK)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DENSE_WOOD_SLAB.get(), ModBlocks.DENSE_WOOD_BLOCK);

        pressurePlate(recipeOutput, ModBlocks.DENSE_WOOD_PRESSURE_PLATE.get(), ModBlocks.DENSE_WOOD_BLOCK);

        wall(recipeOutput,  RecipeCategory.BUILDING_BLOCKS, ModBlocks.DENSE_WOOD_WALL.get(), ModBlocks.DENSE_WOOD_BLOCK);

        //</editor-fold>

        //<editor-fold desc="Crystal Tools">
        //vanilla tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_SWORD.get())
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_sword_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_PICKAXE.get())
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_pickaxe_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_AXE.get())
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_axe_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_AXE.get())
                .pattern(" CC")
                .pattern(" SC")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_axe_recipe_reversed");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_SHOVEL.get())
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_shovel_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_HOE.get())
                .pattern("CC ")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_hoe_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_HOE.get())
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_hoe_recipe_reversed");

        //custom hammer tool
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_HAMMER.get())
                .pattern("CCC")
                .pattern("CSC")
                .pattern(" S ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_hammer_recipe");

        //armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_helmet_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_HELMET.get())
                .pattern("   ")
                .pattern("CCC")
                .pattern("C C")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_helmet_recipe_lowered");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_chestplate_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_leggings_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_BOOTS.get())
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_boots_recipe");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_BOOTS.get())
                .pattern("C C")
                .pattern("C C")
                .pattern("   ")
                .define('C', ModItems.CRYSTALFRAGMENTS.get())
                .unlockedBy("has_crystalfragment", has(ModItems.CRYSTALFRAGMENTS)).save(recipeOutput,"alkahistorycraft:crystal_boots_recipe_raised");


        //</editor-fold>

        trimSmithing(recipeOutput, ModItems.REGAL_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, "regal"));
    }


    //fixes for mojangs rigid code (again)

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AlkahistoryCraft.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
