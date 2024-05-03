package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class SniperItem extends Item { // Professionals have standards
    public SniperItem(Settings settings) {
        super(settings);
    }

    public boolean hasBullet(PlayerEntity playerEntity, ItemStack stack){

        if (stack.isOf(ModItems.BULLET)){
            playerEntity.getInventory().removeOne(stack); //Be polite
            return true;
        }else {
            return false;
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getOffHandStack();
        user.getItemCooldownManager().set(this, 60); //Be efficient

        if (!world.isClient) {

            if (itemStack.isOf(ModItems.SNIPER_BULLET)) {

                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_SNIPER_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.4F, 1.0F);
                BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
                bulletProjectileEntity.bulletDamage = 50;
                bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 70.5F, 0.0F);
                world.spawnEntity(bulletProjectileEntity);
            }else {
                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_GUN_DRY_FIRE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            }

        }
        if (!user.getAbilities().creativeMode) { // Have a plan to kill anyone you meet
            itemStack.decrement(1);
        }

        return super.use(world, user, hand);
    }


}// Dad I'm not a crazed gunman dad I'm an assassin . What the difference be ? The one is a job and the other's mental sickness
