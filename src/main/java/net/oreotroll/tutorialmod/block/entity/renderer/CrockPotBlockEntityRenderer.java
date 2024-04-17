package net.oreotroll.tutorialmod.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.block.entity.CrockPotBlockEntity;

public class CrockPotBlockEntityRenderer implements BlockEntityRenderer<CrockPotBlockEntity> {
    public CrockPotBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }



    @Override
    public void render(CrockPotBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getRenderStack();
        matrices.push();
        matrices.translate(0.5f,0.8f, 0.5f); //Handles the position
        matrices.scale(0.35f, 0.35f,0.35f); //Handles the size
        matrices.multiply(RotationAxis.POSITIVE_X.rotation(5));//controlls the rotation of the item 130

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightlevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV,matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightlevel(World world, BlockPos pos){
        int bright = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bright,sLight);
    }
}
