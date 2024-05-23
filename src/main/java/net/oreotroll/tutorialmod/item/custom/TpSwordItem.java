package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TpSwordItem extends SwordItem {
    public TpSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        double reach = 5;

        double[] targetPosition = getTargetPosition(user.getX(), user.getY(), user.getZ(),
                user.getPitch(), user.getYaw(), reach);

        BlockPos pos = new BlockPos((int) targetPosition[0],(int)targetPosition[1],(int)targetPosition[2]);

        if (isBlockValid(pos,world,0)){
            user.teleport(targetPosition[0],targetPosition[1],targetPosition[2]);
            user.getItemCooldownManager().set(this,30);
        } else {
            user.getItemCooldownManager().set(this,10);
        }
        return super.use(world, user, hand);
    }


    public static double[] getTargetPosition(double x, double y, double z, double pitch, double yaw, double distance) {

        if (pitch >= 0 && !(pitch > 60)){ //This is to avoid clipping into the ground . For now you simply arent able to tp down.
            pitch = -0.1; // I will probably add some fancy raycasting check and if theres a block in the way you wont be able to teleport
        }

        // Convert degrees to radians
        double pitchRad = Math.toRadians(pitch);
        double yawRad = Math.toRadians(yaw);

        // Calculate direction vector
        double directionX = -Math.cos(pitchRad) * Math.sin(yawRad);
        double directionY = -Math.sin(pitchRad);
        double directionZ = Math.cos(pitchRad) * Math.cos(yawRad);

        // Calculate the target coordinates
        double targetX = x + distance * directionX;
        double targetY = y + distance * directionY;
        double targetZ = z + distance * directionZ;

        return new double[] { targetX, targetY, targetZ };
    }

    private boolean isBlockValid (BlockPos block, World world, int offset) {
        BlockState blockStateFeet = world.getBlockState(block.down());

        return blockStateFeet.isOf(Blocks.TALL_GRASS) || blockStateFeet.isOf(Blocks.GRASS) || blockStateFeet.isOf(Blocks.AIR) || blockStateFeet.isOf(Blocks.WATER);
    }
}
