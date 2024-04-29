package net.oreotroll.tutorialmod.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

public class ModTags { // Some of the quotes in code comments are 1984 references
    public static class Blocks{

        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
                createTag("metal_detector_detectable_blocks");

// Did you know my internet username used to be oreotroll_TURBO
// I first made it in TankiOnline

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items{

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TutorialMod.MOD_ID, name));
        }
    }
}
//Oranges and lemons,
//Say the bells of St. Clement's.