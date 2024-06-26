package net.oreotroll.tutorialmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.entity.custom.PorcupineEntity;

public class PorcupineRenderer extends MobEntityRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/porcupine.png");

    public PorcupineRenderer(EntityRendererFactory.Context context) {
        super(context, new PorcupineModel<>(context.getPart(ModModelLayers.PORCUPINE)), 0.6f);
    }

    @Override
    public Identifier getTexture(PorcupineEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PorcupineEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if (mobEntity.isBaby()){ //I made the baby tiny becaue I thought it would be funny
            matrixStack.scale(0.2f,0.2f,0.2f);
        }
        else {
            matrixStack.scale(1f,1f,1f);  // The urge to make the models huge was insane but I resisted
        }


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
