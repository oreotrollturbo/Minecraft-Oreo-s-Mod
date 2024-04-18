package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.block.custom.DiceBlock;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.item.ModItems;

public class BulletProjectileEntity extends ThrownItemEntity {

    public int bulletDamage = 30; //damage of the bullet 30 by default


    public BulletProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.BULLET_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BULLET;
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
}
