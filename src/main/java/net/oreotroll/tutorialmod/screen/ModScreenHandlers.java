package net.oreotroll.tutorialmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.particle.TotemParticle;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CrockPotScreenHandler> CROCK_POT_SCREEN_HANDLER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(TutorialMod.MOD_ID,"crock_pot"),
                    new ExtendedScreenHandlerType<>(CrockPotScreenHandler::new));


    public static void registerScreenHandlers(){
        TutorialMod.LOGGER.info("Registering Screen Handlers for " + TutorialMod.MOD_ID);
    }
}
