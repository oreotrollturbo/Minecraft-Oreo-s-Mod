package net.oreotroll.tutorialmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.oreotroll.tutorialmod.block.ModBlocks;
import net.oreotroll.tutorialmod.item.ModItems;
import net.oreotroll.tutorialmod.villager.ModVillagers;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.KEN_SWORD, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 67),
                            new ItemStack(ModItems.KEN_AXE, 1),
                            6, 5, 0.05f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 70),
                            new ItemStack(ModItems.KEN_HELMET, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 80),
                            new ItemStack(ModItems.KEN_CHESTPLATE, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 75),
                            new ItemStack(ModItems.KEN_LEGGINGS, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 68),
                            new ItemStack(ModItems.KEN_BOOTS, 1),
                            6, 5, 0.05f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.KEN_PICKAXE, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.KEN_SHOVEL, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.KEN_HOE, 1),
                            6, 5, 0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH,5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.KEN_SWORD, 1),
                            6, 5, 0.05f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 67),
                            new ItemStack(ModItems.KEN_AXE, 1),
                            6, 5, 0.05f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.VODKA, 1),
                            64, 5, 0.005f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.KEN_INGOT, 2),
                            EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.MENDING,4)),
                            6, 40, 0.05f
                    ));
                });
        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.KEN_STAFF, 1),
                            2, 30, 0.5f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.UNI, 1),
                            6, 30, 1f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(ModItems.NYX, 1),
                            6, 30, 1f
                    ));
                });



        TradeOfferHelper.registerVillagerOffers(ModVillagers.VILLAGERTROLLTURBO, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.KEN_INGOT, 5),
                            new ItemStack(ModBlocks.YABUKI_BLOCK, 1),
                            10, 40, 0.0005f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.KEN_INGOT, 1),
                            new ItemStack(ModBlocks.KILLZ_BLOCK, 1),
                            40, 40, 0.0005f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.KEN_INGOT, 3),
                            new ItemStack(ModBlocks.KUI_BLOCK, 1),
                            6, 40, 0.0005f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.UNI, 1),
                            new ItemStack(ModItems.NYX, 1),
                            20, 40, 0.0005f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.NYX, 1),
                            new ItemStack(ModItems.UNI, 1),
                            20, 40, 0.0005f
                    ));
                });
    }

}
