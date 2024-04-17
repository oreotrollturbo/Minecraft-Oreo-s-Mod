package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.entity.ai.PorcupineAttackGoal;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.SharedLibrary;

import java.security.PrivateKey;

public class PorcupineEntity extends AnimalEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(PorcupineEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackingAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public PorcupineEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }



    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackingAnimationState.start(this.age);
        }else {
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking()){
            attackingAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new PorcupineAttackGoal(this,1D,true));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.140));
        this.goalSelector.add(2, new TemptGoal(this, 1.140, Ingredient.ofItems(ModItems.VODKA), false));
        this.goalSelector.add(2, new ChaseBoatGoal(this));
        this.goalSelector.add(3, new FollowParentGoal(this,1D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this,1D));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class,4f));


        this.targetSelector.add(1, new RevengeGoal(this));
    }


    public static DefaultAttributeContainer.Builder createPorupineAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED , 3f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.05f);
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING,attacking);
    }


    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING,false);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PORCUPINE.create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.VODKA);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PARROT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_GOAT_DEATH;
    }
}
