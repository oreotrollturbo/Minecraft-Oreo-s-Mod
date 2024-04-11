package net.oreotroll.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "oreosmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mymod"))
                    .icon(() -> new ItemStack(ModItems.RAW_KEN)).entries((displayContext, entries) -> { //when minecraft starts

                        entries.add(ModItems.UNI);
                        entries.add(ModItems.NYX);
                        entries.add(ModItems.RAW_KEN);
                        entries.add(ModItems.KEN_INGOT);

                        entries.add(ModItems.METAL_DETECTOR);


                        entries.add(ModBlocks.KEN_BLOCK);
                        entries.add(ModBlocks.KEN_ORE);
                        entries.add(ModBlocks.NYX_BLOCK);
                        entries.add(ModBlocks.KUI_BLOCK);
                        entries.add(ModBlocks.KILLZ_BLOCK);
                        entries.add(ModBlocks.UNI_BLOCK);

                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(Items.STICK);

                    }).build());



public static void registerItemGroups() {
    TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}

