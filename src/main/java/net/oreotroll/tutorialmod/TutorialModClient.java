package net.oreotroll.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.entity.client.ModModelLayers;
import net.oreotroll.tutorialmod.entity.client.PorcupineModel;
import net.oreotroll.tutorialmod.entity.client.PorcupineRenderer;
import net.oreotroll.tutorialmod.screen.CrockPotScreen;
import net.oreotroll.tutorialmod.screen.ModScreenHandlers;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    System.out.println("Hello World !");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEN_TRAPDOOR, RenderLayer.getCutout());


        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.CROCK_POT_SCREEN_HANDLER_SCREEN_HANDLER, CrockPotScreen::new);
    }
}
