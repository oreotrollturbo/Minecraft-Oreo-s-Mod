package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.entity.custom.BallOfFireEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class KenOpStaffItem extends Item {
    public KenOpStaffItem(Settings settings) {
        super(settings);
    }




    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient) {

            BallOfFireEntity ballOfFireEntity = new BallOfFireEntity(user, world);
            ballOfFireEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.3F, 0.0F);
            world.spawnEntity(ballOfFireEntity);
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Unlimited power"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
