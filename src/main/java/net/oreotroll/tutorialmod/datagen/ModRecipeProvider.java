package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> KEN_SMELTABLES = List.of(ModItems.RAW_KEN,
            ModBlocks.KEN_ORE); //makes a list of all items to be smelted into ken ore
    private static final List<ItemConvertible> EGG_SMELTABLE = List.of(Items.EGG);
//I wanted to add this one individually but it needs a string to be used so :(


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, KEN_SMELTABLES, RecipeCategory.MISC,ModItems.KEN_INGOT,//How its gonna smelt
                10f, 200,"ken");
        offerBlasting(exporter, KEN_SMELTABLES, RecipeCategory.MISC,ModItems.KEN_INGOT,//How its gonna blast
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.YABUKI_BLOCK,1) //THE FUNNI
                .pattern("VVV")
                .pattern("VIV")
                .pattern("VVV")
                .input('I',Items.DIAMOND)
                .input('V',ModItems.UNI)
                .criterion(hasItem(ModItems.UNI),conditionsFromItem(ModItems.UNI))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.YABUKI_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SOUND_BLOCK,1)
                .pattern("VVV")
                .pattern("VIV")
                .pattern("VVV")
                .input('I',ModBlocks.NYX_BLOCK)
                .input('V',Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SOUND_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.CROCK_POT,1)
                .pattern("QUQ")
                .pattern("VIV")
                .pattern("V V")
                .input('I',Items.CHARCOAL)
                .input('Q',Items.DIAMOND)
                .input('U',ModItems.KEN_INGOT)
                .input('V',Items.STICK)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CROCK_POT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.BULLET,16)
                .pattern("   ")
                .pattern("IV ")
                .pattern("   ")
                .input('I',Items.GUNPOWDER)
                .input('V', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT),conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BULLET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GUN,1)
                .pattern("III")
                .pattern("  V")
                .pattern("   ")
                .input('I',ModItems.KEN_INGOT)
                .input('V', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GUN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SNIPER_BULLET,6)
                .pattern("   ")
                .pattern("IIV")
                .pattern("   ")
                .input('I',Items.GUNPOWDER)
                .input('V', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SNIPER_BULLET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SNIPER,1)
                .pattern("III")
                .pattern("III")
                .pattern("  V")
                .input('I',ModItems.KEN_INGOT)
                .input('V', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SNIPER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.METAL_DETECTOR,1)
                .pattern("VJV")
                .pattern(" N ")
                .pattern("III")
                .input('I',Blocks.IRON_BLOCK)
                .input('V', Items.DIAMOND)
                .input('N', ModItems.KEN_INGOT)
                .input('J', Blocks.JUKEBOX)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RAIL_GUN,1)
                .pattern("III")
                .pattern(" VN")
                .pattern("   ")
                .input('V',ModBlocks.KEN_BLOCK)
                .input('I', Items.DIAMOND_BLOCK)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAIL_GUN)));





        createDoorRecipe(ModBlocks.KEN_DOOR, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createTrapdoorRecipe(ModBlocks.KEN_TRAPDOOR, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createFenceRecipe(ModBlocks.KEN_FENCE, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createFenceGateRecipe(ModBlocks.KEN_FENCE_GATE, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));
        createStairsRecipe(ModBlocks.KEN_STAIRS, Ingredient.ofItems(ModItems.KEN_INGOT)).criterion(hasItem(ModItems.KEN_INGOT),conditionsFromItem(ModItems.KEN_INGOT));



    }
}
