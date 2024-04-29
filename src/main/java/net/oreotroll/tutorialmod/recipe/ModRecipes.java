package net.oreotroll.tutorialmod.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TutorialMod.MOD_ID, CrockPotRecipe.Serializer.ID),
                CrockPotRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TutorialMod.MOD_ID, CrockPotRecipe.Type.ID),
                CrockPotRecipe.Type.INSTANCE);
    }//This is lame
    //Its just registering stuff
}
