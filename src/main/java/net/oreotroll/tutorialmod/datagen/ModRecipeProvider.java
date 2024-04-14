package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> KEN_SMELTABLES = List.of(ModItems.RAW_KEN,
            ModBlocks.KEN_ORE); //makes a list of all items to be smelted into ken ore
    private static final List<ItemConvertible> EGG_SMELTABLE = List.of(Items.EGG);
//I wanted to add this one individually but it needs a string to be used so :(


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, KEN_SMELTABLES, RecipeCategory.MISC,ModItems.KEN_INGOT,//How its gonna smelt
                10f, 200,"ken");
        offerBlasting(exporter, KEN_SMELTABLES, RecipeCategory.MISC,ModItems.KEN_INGOT,//How its gonna blast
                10f, 100,"ken");
        offerSmelting(exporter, EGG_SMELTABLE, RecipeCategory.MISC,ModItems.PIEROGI,//how its gonna smelt
                10f, 100,"ken");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.KEN_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.KEN_BLOCK); //This single line adds crafting and uncrafting of the ken block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.NYX, RecipeCategory.DECORATIONS,
                ModBlocks.NYX_BLOCK); //This single line adds crafting and uncrafting of the Nyx block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.UNI, RecipeCategory.DECORATIONS,
                ModBlocks.UNI_BLOCK); //This single line adds crafting and uncrafting of the uni block

//Adds the ken button hopefully ?

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RAW_KEN,1)
                .pattern("III")
                .pattern("IVI")
                .pattern("III")
                .input('I',Items.IRON_INGOT)
                .input('V',ModItems.VODKA)
                .criterion(hasItem(ModItems.VODKA),conditionsFromItem(ModItems.VODKA))
                .criterion(hasItem(ModItems.RAW_KEN),conditionsFromItem(ModItems.RAW_KEN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_KEN)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.KEN_SLAB,6) //Adds slabs
                .pattern("   ")
                .pattern("   ")
                .pattern("III")
                .input('I',ModItems.KEN_INGOT)
                .criterion(hasItem(ModBlocks.KEN_SLAB),conditionsFromItem(ModBlocks.KEN_SLAB))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEN_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.KEN_PRESSURE_PLATE,1)//Adds pressure plates
                .pattern("   ")
                .pattern("   ")
                .pattern("II ")
                .input('I',ModItems.KEN_INGOT)
                .criterion(hasItem(ModBlocks.KEN_PRESSURE_PLATE),conditionsFromItem(ModBlocks.KEN_PRESSURE_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEN_PRESSURE_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.KEN_BUTTON,1)//Adds pressure plates
                .pattern("   ")
                .pattern(" I ")
                .pattern("   ")
                .input('I',ModItems.KEN_INGOT)
                .criterion(hasItem(ModBlocks.KEN_BUTTON),conditionsFromItem(ModBlocks.KEN_BUTTON))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEN_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.VODKA,2)//Adds pressure plates
                .pattern("   ")
                .pattern(" I ")
                .pattern("   ")
                .input('I',Items.POTATO)
                .criterion(hasItem(Items.POTATO),conditionsFromItem(Items.POTATO))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VODKA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.KEN_STAFF,1) //Adds slabs
                .pattern("V  ")
                .pattern("I  ")
                .pattern("I  ")
                .input('I',Items.DIAMOND)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_STAFF)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.KEN_SWORD,1) //Adds slabs
                .pattern("V  ")
                .pattern("V  ")
                .pattern("I  ")
                .input('I',Items.STICK)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.KEN_SHOVEL,1) //Adds slabs
                .pattern("V  ")
                .pattern("I  ")
                .pattern("I  ")
                .input('I',Items.STICK)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.KEN_PICKAXE,1) //Adds slabs
                .pattern("VVV")
                .pattern(" I ")
                .pattern(" I ")
                .input('I',Items.STICK)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.KEN_AXE,1) //Adds slabs
                .pattern(" VV")
                .pattern(" IV")
                .pattern(" I ")
                .input('I',Items.STICK)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.KEN_HOE,1) //Adds slabs
                .pattern(" VV")
                .pattern(" I ")
                .pattern(" I ")
                .input('I',Items.STICK)
                .input('V',ModItems.KEN_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KEN_HOE)));




        createDoorRecipe(ModBlocks.KEN_DOOR, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createTrapdoorRecipe(ModBlocks.KEN_TRAPDOOR, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createFenceRecipe(ModBlocks.KEN_FENCE, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createFenceGateRecipe(ModBlocks.KEN_FENCE_GATE, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createStairsRecipe(ModBlocks.KEN_STAIRS, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));



    }
}
