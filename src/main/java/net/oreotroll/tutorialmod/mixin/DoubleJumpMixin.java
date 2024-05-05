package net.oreotroll.tutorialmod.mixin;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.oreotroll.tutorialmod.item.ModItems;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true) //I have no clue why this fixed the double jump but it somehow did and Im not gonna question it
@Mixin(ClientPlayerEntity.class)
    public abstract class DoubleJumpMixin {
        private int jumpCount = 0;
        private boolean jumpedLastTick = false;

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tickMovement(CallbackInfo info) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        if (player.isOnGround() || player.isClimbing()) {
            jumpCount = 1;
        } else if (!jumpedLastTick && jumpCount > 0 && player.getVelocity().y < 0) {
            if (player.input.jumping && !player.getAbilities().flying) {
                if (canJump(player) && isWearingKenBoots(player)) {
                    --jumpCount;
                    player.jump();


                    PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                    passedData.writeUuid(player.getUuid());


                }
            }
        }
        jumpedLastTick = player.input.jumping;
    }


    private boolean wearingUsableElytra(ClientPlayerEntity player) {
        ItemStack chestItemStack = player.getEquippedStack(EquipmentSlot.CHEST);
        return chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(chestItemStack);
    }

    private boolean canJump(ClientPlayerEntity player) {
        return !wearingUsableElytra(player) && !player.isFallFlying() && !player.hasVehicle()
                && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.LEVITATION);
    }

    private boolean isWearingKenBoots(ClientPlayerEntity player) {
        ItemStack bootsItemStack = player.getEquippedStack(EquipmentSlot.FEET);
        return bootsItemStack.getItem() == ModItems.KEN_BOOTS;
    }
}
