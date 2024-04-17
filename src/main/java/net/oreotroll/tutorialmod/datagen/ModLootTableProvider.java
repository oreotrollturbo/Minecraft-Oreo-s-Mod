package net.oreotroll.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.KEN_BLOCK);//Theese simply drop themselves
        addDrop(ModBlocks.NYX_BLOCK);
        addDrop(ModBlocks.UNI_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.YABUKI_BLOCK);


        addDrop(ModBlocks.KEN_STAIRS);//done
        addDrop(ModBlocks.NYX_STAIRS);//done
        addDrop(ModBlocks.KEN_TRAPDOOR);//done
        addDrop(ModBlocks.KEN_WALL);
        addDrop(ModBlocks.KEN_FENCE);//done
        addDrop(ModBlocks.KEN_FENCE_GATE);//done
        addDrop(ModBlocks.KEN_BUTTON);//done
        addDrop(ModBlocks.KEN_PRESSURE_PLATE);
        addDrop(ModBlocks.KUI_BLOCK);


        addDrop(ModBlocks.CROCK_POT);


        addDrop(ModBlocks.KEN_DOOR, doorDrops(ModBlocks.KEN_DOOR)); //done
        addDrop(ModBlocks.KEN_SLAB, slabDrops(ModBlocks.KEN_SLAB));




        addDrop(ModBlocks.KEN_ORE, copperLikeOreDrops(ModBlocks.KEN_ORE, ModItems.RAW_KEN));
    } //This one steals from the copied coper ore code

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                .create(1.0f, 2.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    } //This is said stolen copper ore code
}
