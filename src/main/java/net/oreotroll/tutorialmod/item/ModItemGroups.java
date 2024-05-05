package net.oreotroll.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "oreosmod"), //oreosmod is such a bad name but fuck it we ball
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mymod"))
                    .icon(() -> new ItemStack(ModItems.RAW_KEN)).entries((displayContext, entries) -> { //when minecraft starts

                        entries.add(ModItems.UNI);
                        entries.add(ModItems.NYX);
                        entries.add(ModItems.DEATH_);
                        entries.add(ModItems.RAW_KEN);
                        entries.add(ModItems.KEN_INGOT);
                        entries.add(ModItems.RUBY);

                        entries.add(ModItems.VODKA);
                        entries.add(ModItems.PIEROGI);
                        entries.add(ModItems.MEAT_BALLS);

                        entries.add(ModItems.METAL_DETECTOR);


                        entries.add(ModItems.JETPACK_HELLRIDE_MUSIC_DISC);
                        entries.add(ModItems.KEN_WAITING_FOR_LOVE_MUSIC_DISC);
                        entries.add(ModItems.CANT_GO_TO_HELL_MUSIC_DISC);


                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModBlocks.NYX_BLOCK);
                        entries.add(ModBlocks.DEATH__BLOCK);
                        entries.add(ModBlocks.NYX_STAIRS);
                        entries.add(ModBlocks.KUI_BLOCK);
                        entries.add(ModBlocks.KILLZ_BLOCK);
                        entries.add(ModBlocks.UNI_BLOCK);
                        entries.add(ModBlocks.YABUKI_BLOCK);
                        entries.add(ModBlocks.KEN_BLOCK);
                        entries.add(ModBlocks.KEN_ORE);


                        entries.add(ModBlocks.KEN_STAIRS);
                        entries.add(ModBlocks.KEN_SLAB);
                        entries.add(ModBlocks.KEN_BUTTON);
                        entries.add(ModBlocks.KEN_PRESSURE_PLATE);
                        entries.add(ModBlocks.KEN_FENCE);
                        entries.add(ModBlocks.KEN_FENCE_GATE);
                        entries.add(ModBlocks.KEN_DOOR);
                        entries.add(ModBlocks.KEN_TRAPDOOR);
                        entries.add(ModBlocks.KEN_WALL);


                        entries.add(ModItems.KEN_STAFF);
                        entries.add(ModItems.KEN_OP_STAFF);
                        entries.add(ModItems.KEN_SHOVEL);
                        entries.add(ModItems.KEN_HOE);
                        entries.add(ModItems.KEN_PICKAXE);
                        entries.add(ModItems.KEN_AXE);
                        entries.add(ModItems.KEN_SWORD);
                        entries.add(ModItems.KEN_SHIELD);

                        entries.add(ModItems.KEN_HELMET);
                        entries.add(ModItems.KEN_CHESTPLATE);
                        entries.add(ModItems.KEN_LEGGINGS);
                        entries.add(ModItems.KEN_BOOTS);


                        entries.add(ModItems.PORCUPINE_SPAWN_EGG);


                        entries.add(ModBlocks.CROCK_POT);

                        entries.add(ModItems.DICE);
                        entries.add(ModItems.BULLET);
                        entries.add(ModItems.SNIPER_BULLET);

                        entries.add(ModItems.GUN);
                        entries.add(ModItems.SNIPER);
                        entries.add(ModItems.RAIL_GUN);
                        entries.add(ModItems.GLOCK);



                    }).build());



public static void registerItemGroups() {
    TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}

