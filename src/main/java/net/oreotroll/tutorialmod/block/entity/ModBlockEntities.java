package net.oreotroll.tutorialmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<CrockPotBlockEntity> CROCK_POT_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TutorialMod.MOD_ID,"crock_pot"),
                    FabricBlockEntityTypeBuilder.create(CrockPotBlockEntity::new ,
                            ModBlocks.CROCK_POT).build()); //simply registers the block entity



    public static void registerBlockEntities(){
        TutorialMod.LOGGER.info("Registering Custom Blocks for " + TutorialMod.MOD_ID); //I have nothing to say about this one
    }

}
