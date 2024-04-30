package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.ModEntities;

public class RailGunProjectileEntity extends ThrownItemEntity {

    public int bulletDamage = 500; //the damage of the bullet 30 by default


    public RailGunProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public RailGunProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.RAILGUN_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.AIR;
   }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), (float)bulletDamage);
    }


    @Override
    protected void onCollision(HitResult hitResult) { //The sleep deprivation is getting into my head
        super.onCollision(hitResult);
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte) 3);
        }
    }

    protected int waterTickCounter = 0;
    private int tickCounter = 0;

    @Override
    public void tick() {

        if (this.getWorld().isClient){ //This projectile is hydrophobic . why? Well because I said so
            if (isTouchingWater()){
                if (waterTickCounter >= 5){//kills the projectile after one fourth of a second in water
                    discard();
                    waterTickCounter++;
                }
            }
            if (tickCounter >= 400){ //Makes the projectile kill itself after 20 seconds of being spawned
                discard();
            }
        }
        tickCounter++;
        super.tick();
    }
}
