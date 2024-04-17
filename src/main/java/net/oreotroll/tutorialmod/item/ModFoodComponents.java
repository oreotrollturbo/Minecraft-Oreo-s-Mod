package net.oreotroll.tutorialmod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {

    public static  final FoodComponent PIEROGI = new FoodComponent.Builder().alwaysEdible().hunger(10).saturationModifier(1f).
        statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH ,1,1),1f).meat().build();

    public static  final FoodComponent VODKA = new FoodComponent.Builder().alwaysEdible().hunger(1).saturationModifier(0f).
            statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA ,400,2),1f).meat().build();

    public static  final FoodComponent MEAT_BALLS = new FoodComponent.Builder().alwaysEdible().hunger(1).saturationModifier(0f).
            statusEffect(new StatusEffectInstance(StatusEffects.SATURATION ,1000,1),1f).meat().build();
}
