package net.oreotroll.tutorialmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.block.custom.DiceBlock;
import net.oreotroll.tutorialmod.block.entity.ModBlockEntities;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.item.ModItems;

public class DiceProjectileEntity extends ThrownItemEntity {
    public DiceProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DiceProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.DICE_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DICE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()){
            this.getWorld().sendEntityStatus(this,(byte)3);
            this.getWorld().setBlockState(getBlockPos(), ((DiceBlock) ModBlocks.DICE_BLOCK).getRandomBlockState(), 3);
        }

        this.discard();
        super.onBlockHit(blockHitResult);
    }
}
