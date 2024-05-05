package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import net.oreotroll.tutorialmod.datagen.ModDamageTypes;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.item.ModItems;

public class BulletProjectileEntity extends ThrownItemEntity { // This was the first class I made entirely on my own

    public float bulletDamage = 10f; //the damage of the bullet 30 by default


    public BulletProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.BULLET_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.AIR; //return ModItems.BULLET;
   }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {


        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(ModDamageTypes.of(this.getWorld(), ModDamageTypes.BULLET_DAMAGE_TYPE), bulletDamage);
    }

    private int tickCounter = 0;

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte) 3);
            this.discard();
        }
        tickCounter++;
    } // I am very proud of this one

    public int maxtime = 400; //20 seconds

    @Override
    public void tick() {

        if (tickCounter >= maxtime){ //Makes the projectile kill itself after 20 seconds of being spawned
            discard();
        }

        super.tick();
    }
}
