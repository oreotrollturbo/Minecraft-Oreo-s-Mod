package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.item.Item;


public class SniperBulletItem extends Item {
    public SniperBulletItem(Settings settings) {
        super(settings);
    } //This is just like the bullet item


    //@Override
   // public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //ItemStack itemStack = user.getStackInHand(hand);
       // world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(),
                //ModSounds.SOUND_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        //if (!world.isClient) {
            //BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
            //bulletProjectileEntity.setItem(itemStack);
            //bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 40.5F, 0.0F);//speed 1.5F divergence 1.0F
            //world.spawnEntity(bulletProjectileEntity);
       // }

        //user.incrementStat(Stats.USED.getOrCreateStat(this));
        //if (!user.getAbilities().creativeMode) {
            //itemStack.decrement(1);
        //}

        //return TypedActionResult.success(itemStack, world.isClient());
    //}

}
