package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class RailGunItem extends Item {

    public int getMaxUseTime(ItemStack stack) {
        return 60;}

    public RailGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPYGLASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        //user.getItemCooldownManager().set(this, 120);

        user.playSound(SoundEvents.ITEM_SPYGLASS_USE, 1.0F, 1.0F);
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return ItemUsage.consumeHeldItem(world, user, hand);
        //return TypedActionResult.success();

    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        this.playStopUsingSound(user);


        world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                ModSounds.SOUND_SNIPER_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.4F, 1.0F);
        BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
        bulletProjectileEntity.bulletDamage = 500;
        bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 100.5F, 0.0F);
        world.spawnEntity(bulletProjectileEntity);

        if (user instanceof PlayerEntity playerEntity) {
            ((PlayerEntity) user).getItemCooldownManager().set(this, 180);
        }



        return stack;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if (user instanceof PlayerEntity playerEntity) {
            ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
        }
        this.playStopUsingSound(user);
    }


    private void playStopUsingSound(LivingEntity user) {
        user.playSound(SoundEvents.ITEM_SPYGLASS_STOP_USING, 1.0F, 1.0F);
    }
}
