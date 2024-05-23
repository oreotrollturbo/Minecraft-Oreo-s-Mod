package net.oreotroll.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.entity.custom.*;

public class ModEntities {



    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f,0.7f)).build());

    public static final EntityType<DiceProjectileEntity> DICE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "dice_projectile"),
            FabricEntityTypeBuilder.<DiceProjectileEntity>create(SpawnGroup.MISC,DiceProjectileEntity::new)
                .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());


    public static final EntityType<BulletProjectileEntity> BULLET_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "bullet_projectile"),
            FabricEntityTypeBuilder.<BulletProjectileEntity>create(SpawnGroup.MISC,BulletProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build());

    public static final EntityType<RailGunProjectileEntity> RAILGUN_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "railgun_projectile"),
            FabricEntityTypeBuilder.<RailGunProjectileEntity>create(SpawnGroup.MISC,RailGunProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 0.7f)).build());

    public static final EntityType<ParticleProjectileEntity> PARTICLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "particle_projectile"),
            FabricEntityTypeBuilder.<ParticleProjectileEntity>create(SpawnGroup.MISC,ParticleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build());

    public static final EntityType<RailgunParticleProjectileEntity> RAILGUN_PARTICLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "railgun_particle_projectile"),
            FabricEntityTypeBuilder.<RailgunParticleProjectileEntity>create(SpawnGroup.MISC,RailgunParticleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build());

    public static final EntityType<BallOfFireEntity> BALL_OF_FIRE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "ball_of_fire"),
            FabricEntityTypeBuilder.<BallOfFireEntity>create(SpawnGroup.MISC,BallOfFireEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());

    public static void registerModEntities() {
        TutorialMod.LOGGER.info("Registering Entities for " + TutorialMod.MOD_ID);
    }

    //I'm starting to see shadowy figures appear in the corner of my eye



}
