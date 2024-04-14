package net.oreotroll.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.oreotroll.tutorialmod.block.ModBlocks;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    System.out.println("Hello World !");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEN_TRAPDOOR, RenderLayer.getCutout());
    }
}
