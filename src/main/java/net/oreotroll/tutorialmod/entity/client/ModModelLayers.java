package net.oreotroll.tutorialmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

public class ModModelLayers { //This part feels redundant
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "porcupine"),"main");
    // it feels like it could be put in an already existing class ya know
}
