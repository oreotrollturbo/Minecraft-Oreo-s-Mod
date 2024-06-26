package net.oreotroll.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.oreotroll.tutorialmod.datagen.ModDamageTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;


public class SoundBlock extends Block {

    public Random rand = new Random();

    public SoundBlock(Settings settings) {
        super(settings);
    } // This block has nothing to do with sounding

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        float random = rand.nextFloat(); //So we can add a random value to the pitch

        world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), SoundCategory.BLOCKS, 100.5f,random); // Yeah I tried to make it an eararpe but the volume us capped :(
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity) {
            entity.damage(ModDamageTypes.of(world, ModDamageTypes.BULLET_DAMAGE_TYPE), 1.0f);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("Makes an epic BASS sound when right-clicked"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
