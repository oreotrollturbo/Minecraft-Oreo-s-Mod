package net.oreotroll.tutorialmod;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.block.entity.ModBlockEntities;
import net.oreotroll.tutorialmod.datagen.ModModelProvider;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.entity.custom.PorcupineEntity;
import net.oreotroll.tutorialmod.item.ModItemGroups;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.item.ModToolMaterial;
import net.oreotroll.tutorialmod.recipe.ModRecipes;
import net.oreotroll.tutorialmod.screen.ModScreenHandlers;
import net.oreotroll.tutorialmod.sound.ModSounds;
import net.oreotroll.tutorialmod.util.ModCustomTrades;
import net.oreotroll.tutorialmod.util.ModLootTableModifiers;
import net.oreotroll.tutorialmod.villager.ModVillagers;
import net.oreotroll.tutorialmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.oreotroll.tutorialmod.item.ModItems.KEN_SHIELD;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() { // this simply initialises ze mod

		ModEntities.registerModEntities();

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.ModifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorupineAttributes());

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.VODKA,400);


		Registry.register(Registries.PARTICLE_TYPE, new Identifier("tutorialmod", "green_flame"), GREEN_FLAME);

		Registry.register(Registries.ITEM, new Identifier("tutorialmod", "ken_shield"), KEN_SHIELD);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(KEN_SHIELD);
		});

	}

	public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();

	 // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItems)


}// I do not know,
//Says the great bell at Bow.