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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.ModEntities;

public class RailgunParticleProjectileEntity extends ThrownItemEntity {

    public boolean isRailgun;



    @Override
    protected float getGravity() {
        return 0;
    }


    public RailgunParticleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public RailgunParticleProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.RAILGUN_PARTICLE_PROJECTILE,livingEntity, world);
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

    final Vec3d vec3d = this.getVelocity();



    protected int tickCounter = 0;
    protected int waterTickCounter = 0;

    @Override
    public void tick() {
        if (this.getWorld().isClient) {

            if (isTouchingWater()){
                if (waterTickCounter >= 20){//kills it after a second in water
                    discard();
                    waterTickCounter++;
                }
            }
            spawnParticles(1);

            if (tickCounter >= 200){//kills it after 10 seconds
                discard();
            }

        }
        tickCounter++;
        super.tick();
    }



}
