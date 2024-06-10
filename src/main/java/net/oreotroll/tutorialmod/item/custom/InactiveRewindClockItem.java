package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;


public class InactiveRewindClockItem extends Item {

     Position rewindPosition;
     float rewindHealth;
     DimensionType rewindDimension;
    boolean isActive = false;

    @Override
    public boolean hasGlint(ItemStack stack) {
        return isActive;
    }

    public InactiveRewindClockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (isActive){
                if (rewindDimension == world.getDimension()){
                    user.teleport(rewindPosition.getX(),rewindPosition.getY(),rewindPosition.getZ(), true);
                    user.getItemCooldownManager().set(this,20);
                    isActive = false;
                }else {
                    assert MinecraftClient.getInstance().player != null;
                    MinecraftClient.getInstance().player.sendMessage(Text.literal("§c You arent in the same dimension"),true);
                }
            }else {
                rewindPosition = user.getPos();
                rewindHealth = user.getHealth();
                rewindDimension = world.getDimension();
                isActive = true;
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
