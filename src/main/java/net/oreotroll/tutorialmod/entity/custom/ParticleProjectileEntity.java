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

public class ParticleProjectileEntity extends ThrownItemEntity { //The amount of hours I've spent on this class is depressing

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
    public Packet<ClientPlayPacketListener> createSpawnPacket() { // Most of this code was written at 2-4am so its probably ass
        return new EntitySpawnS2CPacket(this);
    }



    private void spawnParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.ELECTRIC_SPARK, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }
    private void spawnBubbleParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.BUBBLE, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }

    public int maxParticletime = 400; //max time before discard

    private int tickCounter = 0;

    @Override
    public void tick() {
        if (this.getWorld().isClient) {

            if (this.isTouchingWater()) {
                spawnBubbleParticles(1);
            }else {
                spawnParticles(1);
            }
            if (tickCounter >= maxParticletime){ //Makes the projectile kill itself after 20 seconds of being spawned
                discard();
            }
        }
        tickCounter++;
        super.tick();
    } // no matter how ass these solutions are at least they work so im keeping them



}
