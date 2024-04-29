package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.RailGunProjectileEntity;
import net.oreotroll.tutorialmod.entity.custom.RailgunParticleProjectileEntity;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class RailGunItem extends Item {

    public int getMaxUseTime(ItemStack stack) {
        return 55;}// sets how long the charge is

    public RailGunItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {




        user.playSound(ModSounds.SOUND_RAIL_GUN_WINDUP, 1.7F, 1.0F);
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return ItemUsage.consumeHeldItem(world, user, hand);


    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) { // I am really REALLY proud of this item
        this.playStopUsingSound(user);


        world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                ModSounds.SOUND_RAIL_GUN_SHOT, SoundCategory.NEUTRAL, 1.4F, 1.0F);

        RailgunParticleProjectileEntity railgunParticleProjectileEntity = new RailgunParticleProjectileEntity(user, world);
        railgunParticleProjectileEntity.isRailgun = true;
        railgunParticleProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 4.3F, 0.0F); //4.3F
        world.spawnEntity(railgunParticleProjectileEntity);

        RailGunProjectileEntity railGunProjectileEntity = new RailGunProjectileEntity(user, world);
        railGunProjectileEntity.bulletDamage = 500;
        railGunProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 100.5F, 0.0F);
        world.spawnEntity(railGunProjectileEntity);

        if (user instanceof PlayerEntity playerEntity) {
            ((PlayerEntity) user).getItemCooldownManager().set(this, 180);
        }



        return stack;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        // All of this code is a product of my "intelligence"

        if (user instanceof PlayerEntity playerEntity) {
            ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
        }
        this.playStopUsingSound(user);
    }


    private void playStopUsingSound(LivingEntity user) {
        user.playSound(ModSounds.SOUND_RAIL_GUN_WINDOWN, 1.0F, 1.0F);
    }
}
// sometimes it feels like im a genius and some other times like im the dumbest man alive

//one is a delusion and the other is reality