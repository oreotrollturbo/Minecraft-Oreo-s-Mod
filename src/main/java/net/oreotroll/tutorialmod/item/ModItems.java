package net.oreotroll.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.item.custom.MetalDetectorItem;

import java.security.PublicKey;

public class ModItems {

    public  static  final Item RAW_KEN = registerItem("raw_ken", new Item(new FabricItemSettings())); //Officially adds the item
    public  static  final Item UNI = registerItem("uni", new Item(new FabricItemSettings()));
    public  static  final Item NYX = registerItem("nyx", new Item(new FabricItemSettings()));
    public  static  final Item KEN_INGOT = registerItem("ken_ingot", new Item(new FabricItemSettings()));

    public  static  final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    private static void addItemsToIngerdientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RAW_KEN);
        entries.add(UNI);//adds the item
        entries.add(NYX);
        entries.add(KEN_INGOT);
        entries.add(METAL_DETECTOR);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item); //"template" for creating items
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToIngerdientItemGroup);
    }

}
