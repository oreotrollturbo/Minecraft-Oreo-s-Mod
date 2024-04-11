package net.oreotroll.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionclicked = context.getBlockPos(); //Takes the position of the block that was right clicked
            PlayerEntity player = context.getPlayer(); //sets player in an easier to understand variable
            boolean foundBlock = false;

            for(int i = 0; i <= positionclicked.getY() + 64; i++){ //loops through all blocks bellow the block that was right clicked
                BlockState state = context.getWorld().getBlockState(positionclicked.down(i));

                if(isValuabaleBlock(state)){
                    outputValuableCoordinates(positionclicked.down(i), player,state.getBlock());
                    foundBlock = true; //sets the founblock to true once its found a block

                    break;
                }
            }

            if(!foundBlock){
                player.sendMessage(Text.literal("Nothing found :(")); //tells you if it didnt find anything
            }





        }

        context.getStack().damage(1,context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); //decreases the durability by 1 every use



    return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(Y " + blockPos.getY() + ")"), false); //tells you the Y coordinate once its found something
    }

    private boolean isValuabaleBlock(BlockState state) {
        return state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE) || state.isOf(Blocks.SPAWNER) ; //defines what blocks are valuable
    }
}
