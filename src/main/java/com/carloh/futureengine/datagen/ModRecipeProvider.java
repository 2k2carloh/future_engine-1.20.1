package com.carloh.futureengine.datagen;

import com.carloh.futureengine.FutureEngine;
import com.carloh.futureengine.blocks.Modblock;
import com.carloh.futureengine.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> URANIUM_SMELTABLES = List.of(Moditems.URANIUM_RAW.get());
    private static final List<ItemLike> RUBBER_SMELTABLES = List.of(Moditems.RESINE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, URANIUM_SMELTABLES, RecipeCategory.MISC, Moditems.URANIUM_INGOT.get(), 0.25f, 100, "uranium_ingot");
        oreSmelting(pWriter, URANIUM_SMELTABLES, RecipeCategory.MISC, Moditems.URANIUM_INGOT.get(), 0.25f, 200, "uranium_ingot");
        oreSmelting(pWriter, RUBBER_SMELTABLES, RecipeCategory.MISC, Moditems.RUBBER.get(), 0.25f, 200, "rubber");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.URANIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Moditems.URANIUM_INGOT.get())
                .unlockedBy(getHasName(Moditems.URANIUM_INGOT.get()), has(Moditems.URANIUM_INGOT.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_SLAB.get(), 6)
                .pattern("###")
                .define('#', Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_DOOR.get(), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("#")
                .pattern("#")
                .define('#', Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_FENCE.get(), 3)
                .pattern("#@#")
                .pattern("#@#")
                .define('#', Modblock.PINE_PLANKS.get())
                .define('@', Items.STICK)
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_FENCE_GATE.get())
                .pattern("@#@")
                .pattern("@#@")
                .define('#', Modblock.PINE_PLANKS.get())
                .define('@', Items.STICK)
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Modblock.PINE_STAIRS.get(), 4)
                .pattern("  #")
                .pattern(" ##")
                .pattern("###")
                .define('#', Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Modblock.PINE_BUTTON.get(), 1)
                .requires(Modblock.PINE_PLANKS.get())
                .unlockedBy(getHasName(Modblock.PINE_PLANKS.get()), has(Modblock.PINE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.URANIUM_INGOT.get(), 9)
                .requires(Modblock.URANIUM_BLOCK.get())
                .unlockedBy(getHasName(Modblock.URANIUM_BLOCK.get()), has(Modblock.URANIUM_BLOCK.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE,  pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, FutureEngine.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
