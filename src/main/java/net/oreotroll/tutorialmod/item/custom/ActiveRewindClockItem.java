package net.oreotroll.tutorialmod.item.custom;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;


public class ActiveRewindClockItem extends Item {

    Position rewindPosition;
    float rewindHealth;
    DimensionType rewindDimension;
    boolean isActive = false;

    @Override
    public boolean hasGlint(ItemStack stack) {
        return isActive;
    }

    public ActiveRewindClockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        MinecraftServer server = world.getServer();

        ServerWorld nether = server.getWorld(World.NETHER);
        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
        ServerWorld end = server.getWorld(World.END);

        if (!world.isClient) {
            if (isActive){
                if (rewindDimension == world.getDimension()){
                    user.teleport(nether,1,1,1,null,0,0);
                    user.getItemCooldownManager().set(this,20);
                    isActive = false;

                    LivingEntity player = user;
                    //FabricDimensions.teleport(player,nether,rewindDimension);
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
