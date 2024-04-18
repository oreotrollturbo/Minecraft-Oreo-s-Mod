package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class GunItem extends Item {
    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(),
                ModSounds.SOUND_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!world.isClient) {
            //ItemStack itemStack = playerEntity.getProjectileType(stack);
            BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
            //bulletProjectileEntity.setItem(itemStack);
            bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 40.5F, 0.0F);//speed 1.5F divergence 1.0F
            world.spawnEntity(bulletProjectileEntity);
        }
        return super.use(world, user, hand);
    }



}
