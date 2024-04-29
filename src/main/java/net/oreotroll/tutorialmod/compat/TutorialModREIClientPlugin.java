package net.oreotroll.tutorialmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.recipe.CrockPotRecipe;
import net.oreotroll.tutorialmod.screen.CrockPotScreen;

public class TutorialModREIClientPlugin implements REIClientPlugin { // I love the REI mod
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrockPotingCategory());

        registry.addWorkstations(CrockPotingCategory.CROCK_POTING, EntryStacks.of(ModBlocks.CROCK_POT));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CrockPotRecipe.class, CrockPotRecipe.Type.INSTANCE,
                CrockPotingDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), CrockPotScreen.class,
                CrockPotingCategory.CROCK_POTING);
    } // I still hate the name "crock poting"
}