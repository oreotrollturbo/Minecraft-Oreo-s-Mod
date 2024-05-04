package net.oreotroll.tutorialmod.world;

import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> KEN_ORE_KEY = registerKey("ken_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldKenOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.KEN_ORE.getDefaultState()));


        register(context, KEN_ORE_KEY , Feature.ORE, new OreFeatureConfig(overworldKenOres, 4));

    } // I once spent 5 hours looking for a mistake in my code and it ended up being a stupid misspelled file name

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }//tutrialmods

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

//When will you pay me?
//Say the bells at Old Bailey.