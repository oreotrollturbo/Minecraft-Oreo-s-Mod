package net.oreotroll.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.block.entity.ModBlockEntities;
import net.oreotroll.tutorialmod.block.entity.renderer.CrockPotBlockEntityRenderer;
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

        BlockEntityRendererFactories.register(ModBlockEntities.CROCK_POT_BLOCK_ENTITY, CrockPotBlockEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.DICE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BULLET_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.PARTICLE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.RAILGUN_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.RAILGUN_PARTICLE_PROJECTILE, FlyingItemEntityRenderer::new);
        
        ParticleFactoryRegistry.getInstance().register(TutorialMod.GREEN_FLAME, FlameParticle.Factory::new);
    }
}
