package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.KEN_ORE) //Adds what blocks are detectable by the metal detector in one tag
                .add(ModBlocks.KEN_BLOCK)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KEN_ORE) //Adds what blocks need a pick to be mined
                .add(ModBlocks.KEN_BLOCK)
                .add(ModBlocks.UNI_BLOCK)
                .add(ModBlocks.NYX_BLOCK)
                .add(ModBlocks.SOUND_BLOCK)
                .add(ModBlocks.NYX_STAIRS)
                .add(ModBlocks.KUI_BLOCK)
                .add(ModBlocks.YABUKI_BLOCK)
                .add(ModBlocks.CROCK_POT);


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.DICE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.UNI_BLOCK) //Adds the tier of the tool required
                .add(ModBlocks.NYX_BLOCK)
                .add(ModBlocks.DICE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KEN_ORE) //Adds the tier of the tool required
                .add(ModBlocks.KEN_BLOCK)
                .add(ModBlocks.YABUKI_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CROCK_POT);


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.KUI_BLOCK);//Adds the tier of the tool required for netherite (doesent work idk why :( )
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_5")))
                .add(ModBlocks.SOUND_BLOCK);//Only to be broken by the ken pickaxe (doesent work idk why :( )



        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.KEN_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.KEN_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.KEN_WALL);


    }
}
