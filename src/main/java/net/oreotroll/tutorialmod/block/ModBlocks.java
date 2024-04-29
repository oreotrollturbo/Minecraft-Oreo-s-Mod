package net.oreotroll.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.block.custom.CrockPotBlock;
import net.oreotroll.tutorialmod.block.custom.DiceBlock;
import net.oreotroll.tutorialmod.block.custom.SoundBlock;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class ModBlocks { // My collection of wonderfully cursed blocks

    public static final Block KEN_ORE = registerBlock("ken_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(5, 10)));

    public static final Block KEN_BLOCK = registerBlock("ken_block",
        new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK))); //adds the actuall block

    public static final Block NYX_BLOCK = registerBlock("nyx_block", //This block is also a workstation block :)
            new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));

    public static final Block DEATH__BLOCK = registerBlock("death__block",
            new Block(FabricBlockSettings.copyOf(Blocks.ANVIL)));

    public static final Block KUI_BLOCK = registerBlock("kui_block",
            new Block(FabricBlockSettings.copyOf(Blocks.FIRE))); //adds the actuall block

    public static final Block KILLZ_BLOCK = registerBlock("killz_block",
            new Block(FabricBlockSettings.copyOf(Blocks.END_ROD))); //adds the actuall block

    public static final Block UNI_BLOCK = registerBlock("uni_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE))); //adds the actuall block



    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ICE).sounds(ModSounds.SOUND_BLOCK_SOUNDS))); //now uses custom sounds!!

    public static final Block KEN_STAIRS = registerBlock("ken_stairs",
            new StairsBlock(ModBlocks.KEN_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block KEN_SLAB = registerBlock("ken_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block KEN_BUTTON = registerBlock("ken_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK),BlockSetType.IRON,5,true));
    public static final Block KEN_PRESSURE_PLATE = registerBlock("ken_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final Block KEN_FENCE = registerBlock("ken_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block KEN_FENCE_GATE = registerBlock("ken_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.BAMBOO));
    public static final Block KEN_WALL = registerBlock("ken_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block KEN_DOOR = registerBlock("ken_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(),BlockSetType.IRON));
    public static final Block KEN_TRAPDOOR = registerBlock("ken_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(),BlockSetType.IRON));

    public static final Block NYX_STAIRS = registerBlock("nyx_stairs",
            new StairsBlock(ModBlocks.NYX_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)));

    public static final Block YABUKI_BLOCK = registerBlock("yabuki_block",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).lightLevel(7), UniformIntProvider.create(5, 10)));


    public static final Block DICE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "dice_block"),
            new DiceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));


    public static final Block CROCK_POT = registerBlock("crock_pot",
            new CrockPotBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));



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
