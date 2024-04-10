package net.oreotroll.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

public class ModBlocks {

    public static final Block KEN_BLOCK = registerBlock("ken_block",
        new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK))); //adds the actuall block

    public static final Block NYX_BLOCK = registerBlock("nyx_block",
            new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK))); //adds the actuall block

    public static final Block KUI_BLOCK = registerBlock("kui_block",
            new Block(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE))); //adds the actuall block

    public static final Block KILLZ_BLOCK = registerBlock("killz_block",
            new Block(FabricBlockSettings.copyOf(Blocks.END_ROD))); //adds the actuall block

    public static final Block UNI_BLOCK = registerBlock("uni_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE))); //adds the actuall block


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block); //template
    }

    private  static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),//other template
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);//just for the funni


    }
}
