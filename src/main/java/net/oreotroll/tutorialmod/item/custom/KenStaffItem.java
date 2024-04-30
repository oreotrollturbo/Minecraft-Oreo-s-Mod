package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BallOfFireEntity;


public class KenStaffItem extends Item {
    public KenStaffItem(Settings settings) {
        super(settings);
    }




    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient) {


            BallOfFireEntity ballOfFireEntity = new BallOfFireEntity(user, world);
            ballOfFireEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.3F, 0.0F);
            world.spawnEntity(ballOfFireEntity);
        }

        return super.use(world, user, hand);
    }





}
