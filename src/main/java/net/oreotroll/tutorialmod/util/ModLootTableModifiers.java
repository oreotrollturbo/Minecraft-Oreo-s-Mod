package net.oreotroll.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.item.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    private static final Identifier ANCIENT_CITY_ID =
            new Identifier("minecraft","chests/ancient_city");
    private static final Identifier BASTION_HOGLIN_STABLE_ID =
            new Identifier("minecraft","chests/bastion_hoglin_stable");
    private static final Identifier NETHER_BRIDGE =
            new Identifier("minecraft","chests/nether_bridge");
    private static final Identifier STRONGHOLD_LIBRARY_ID =
            new Identifier("minecraft","chests/stronghold_library");
    private static final Identifier WARDEN_ID =
            new Identifier("minecraft","entities/warden");
    //private static final Identifier SUSPICIOUS_SAND_ID =
            //new Identifier("minecraft","archeology/desert_pyramid");


    public static void ModifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ANCIENT_CITY_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) //Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(BASTION_HOGLIN_STABLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.JETPACK_HELLRIDE_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(NETHER_BRIDGE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.JETPACK_HELLRIDE_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(NETHER_BRIDGE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.CANT_GO_TO_HELL_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_LIBRARY_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.KEN_WAITING_FOR_LOVE_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(WARDEN_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) //Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.UNI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 9.3f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WARDEN_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) //Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.NYX))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 9.3f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


        });

        //LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) ->{ //Sus sand needs to be modified a diff way

            //if (SUSPICIOUS_SAND_ID.equals(id)){
                //List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries)); //Keeps the entries that exist
                //entries.add(ItemEntry.builder(ModItems.RAW_KEN).build());
                //entries.add(ItemEntry.builder(ModItems.KEN_STAFF).build());

                //LootPool.Builder pool = LootPool.builder().with(entries);
                //return LootTable.builder().pool(pool).build();
            //}

            //return null;
        //});

    }
}
