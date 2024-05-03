package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.datagen.ModDamageTypes;
import net.oreotroll.tutorialmod.entity.ModEntities;

public class BallOfFireEntity extends ThrownItemEntity {

    private int explosionPower = 3;//the damage of the explosion
    private int directHitDamage = 20; //the damage of the impact


    public BallOfFireEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BallOfFireEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.BALL_OF_FIRE,livingEntity, world);
    }



    @Override
    protected Item getDefaultItem() {
        return Items.FIRE_CHARGE; //return ModItems.BULLET;
   }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }


    @Override
   protected void onCollision(HitResult hitResult) {

        if (!this.getWorld().isClient){
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionPower, true, World.ExplosionSourceType.MOB);
            this.discard();
        }

        super.onCollision(hitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient) {

            Entity entity = entityHitResult.getEntity();
            Entity user = this.getOwner();
            if (entity == user){
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionPower, true, World.ExplosionSourceType.MOB);
                //entity.damage(ModDamageTypes.of(getWorld(),ModDamageTypes.CUSTOM_DAMAGE_TYPE), 0);
            }
            if (user instanceof LivingEntity) {
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionPower, true, World.ExplosionSourceType.MOB);
                entity.damage(this.getDamageSources().thrown(this, this.getOwner()), directHitDamage);
            }
            this.discard();
        }

        super.onEntityHit(entityHitResult);

    }

    private void spawnParticles(int amount) {
        this.getWorld().addParticle(ParticleTypes.FLAME, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5),0.0,0.0,0.0 );
    }

    private int tickCounter = 0;

    @Override
    public void tick() {

        if (this.getWorld().isClient){

            if (tickCounter >= 120){
                discard();
            }
            if (this.isTouchingWater()) {
                discard();
            }
            spawnParticles(4);
        }

        tickCounter++;

        super.tick();
    }
}
