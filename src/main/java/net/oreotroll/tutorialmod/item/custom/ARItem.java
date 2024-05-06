package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BulletProjectileEntity;
import net.oreotroll.tutorialmod.entity.custom.ParticleProjectileEntity;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.sound.ModSounds;

import java.util.Set;
import java.util.logging.Level;

public class ARItem extends Item {
    public ARItem(Settings settings) {
        super(settings);
    }

    public boolean hasBullet(PlayerEntity playerEntity, ItemStack stack){
        //The naming of this gun across the code is about as consistent as my sleep schedule

        if (stack.isOf(ModItems.BULLET)){
            playerEntity.getInventory().removeOne(stack);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


        ItemStack itemStack = user.getOffHandStack();


        if (!world.isClient) {


            if (itemStack.isOf(ModItems.AR_MAG) && !(bulletsInGun >= 30)) { //Mag reload

                itemStack.decrement(1);
                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.AR_RELOAD, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                user.getItemCooldownManager().set(this, 60);
                bulletsInGun = 30;
                user.sendMessage(Text.literal("Ammo 30/30"), true);

            }else if (bulletsInGun > 0){ //Shoot

                shoot(world,user);

                bulletsInGun--;

                user.sendMessage(Text.literal("Ammo " + bulletsInGun +"/30"), true);

            } else if (itemStack.isOf(ModItems.BULLET)) { //Add one bullet manually

                bulletsInGun++;
                itemStack.decrement(1);
                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_GUN_CLICK, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                user.getItemCooldownManager().set(this, 15);
                user.sendMessage(Text.literal("Ammo 1/30"), true);

            } else { // No ammo

                world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SOUND_GUN_DRY_FIRE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

                user.sendMessage(Text.literal("No Ammo"), true);
            }

        }

        return super.use(world, user, hand);
    }

    private void shoot(World world,PlayerEntity user){
        world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                ModSounds.SOUND_BULLET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        ParticleProjectileEntity particleProjectileEntity = new ParticleProjectileEntity(user, world);
        particleProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 4.3F, 0.0F);
        world.spawnEntity(particleProjectileEntity);

        BulletProjectileEntity bulletProjectileEntity = new BulletProjectileEntity(user, world);
        bulletProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 40.5F, 0.0F);
        world.spawnEntity(bulletProjectileEntity);
    }

    private int bulletsInGun = 0;




}



//The shadow creatures are comming
