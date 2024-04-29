package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    } //To be fair most of datagen is boring because all it does is automate tedious work

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool kenPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KEN_BLOCK); //makes this a standrt texture other blocks copy from
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KEN_ORE);
        BlockStateModelGenerator.BlockTexturePool nyxPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NYX_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNI_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEATH__BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KILLZ_BLOCK);//simply makes theese blocks into their cube form
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KUI_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YABUKI_BLOCK);

        kenPool.stairs(ModBlocks.KEN_STAIRS);//copies from the ken block texture
        kenPool.slab(ModBlocks.KEN_SLAB);
        kenPool.pressurePlate(ModBlocks.KEN_PRESSURE_PLATE);
        kenPool.fence(ModBlocks.KEN_FENCE);
        kenPool.fenceGate(ModBlocks.KEN_FENCE_GATE);
        kenPool.wall(ModBlocks.KEN_WALL);
        kenPool.button(ModBlocks.KEN_BUTTON);

        nyxPool.stairs(ModBlocks.NYX_STAIRS);

        blockStateModelGenerator.registerDoor(ModBlocks.KEN_DOOR);//theese are simply added
        blockStateModelGenerator.registerTrapdoor(ModBlocks.KEN_TRAPDOOR);

        blockStateModelGenerator.registerSimpleState(ModBlocks.CROCK_POT); // The crock put is a Dont Starve refference







    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.UNI, Models.GENERATED); //tells the items hot to be shown
        itemModelGenerator.register(ModItems.RAW_KEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.VODKA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATH_, Models.GENERATED);
        itemModelGenerator.register(ModItems.KEN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIEROGI, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEAT_BALLS, Models.GENERATED);

        itemModelGenerator.register(ModItems.JETPACK_HELLRIDE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.KEN_WAITING_FOR_LOVE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANT_GO_TO_HELL_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.KEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KEN_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNIPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAIL_GUN, Models.GENERATED);

        itemModelGenerator.register(ModItems.DICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNIPER_BULLET, Models.GENERATED);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KEN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.KEN_BOOTS));


        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));
    }
}
