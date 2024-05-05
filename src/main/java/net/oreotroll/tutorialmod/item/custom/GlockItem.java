package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.entity.custom.ParticleProjectileEntity;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class GlockItem extends Item {
    public GlockItem(Settings settings) {
        super(settings);
    }

    public boolean hasBullet(PlayerEntity playerEntity, ItemStack stack){


        if (stack.isOf(ModItems.BULLET)){
            playerEntity.getInventory().removeOne(stack);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.jump();

        ItemStack itemStack = user.getOffHandStack();

        if (!world.isClient) {



            if (itemStack.isOf(ModItems.BULLET) || user.getAbilities().creativeMode) {

                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

                ParticleProjectileEntity particleProjectileEntity = new ParticleProjectileEntity(user, world);
                particleProjectileEntity.maxParticletime = 25; //time traveled
                particleProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 4.3F, 0.1F);
                world.spawnEntity(particleProjectileEntity);

                BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
                bulletProjectileEntity.bulletDamage = 5;
                bulletProjectileEntity.maxtime = 25; //time traveled
                bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 30.5F, 0.1F);
                world.spawnEntity(bulletProjectileEntity);

            }else {
                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_GUN_DRY_FIRE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            }

        }
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return super.use(world, user, hand);
    }
    //The shadow creatures are coming


}
