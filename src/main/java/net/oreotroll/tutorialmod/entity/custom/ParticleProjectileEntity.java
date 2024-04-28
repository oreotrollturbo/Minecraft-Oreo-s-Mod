package net.oreotroll.tutorialmod.entity.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.ModEntities;

public class ParticleProjectileEntity extends ThrownItemEntity {

    public boolean isRailgun;

    @Override
    protected float getGravity() {
        return 0;
    }


    public ParticleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ParticleProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.PARTICLE_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.AIR; //return ModItems.BULLET;
   }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }



    private void spawnParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.SONIC_BOOM, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }
    private void spawnBubbleParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.BUBBLE, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }

    private void spawnRailgunParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.SONIC_BOOM, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }


    @Override
    public void tick() {
        if (this.getWorld().isClient) {

            if (this.isTouchingWater()) {
                spawnBubbleParticles(1);
            }else {
                spawnParticles(1);
            }
        }
        super.tick();
    }



}
