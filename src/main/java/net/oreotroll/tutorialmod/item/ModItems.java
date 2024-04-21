package net.oreotroll.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;
import net.oreotroll.tutorialmod.entity.ModEntities;
import net.oreotroll.tutorialmod.item.custom.*;
import net.oreotroll.tutorialmod.sound.ModSounds;

public class ModItems {

    public  static  final Item RAW_KEN = registerItem("raw_ken", new Item(new FabricItemSettings())); //Officially adds the item
    public  static  final Item UNI = registerItem("uni", new Item(new FabricItemSettings()));
    public  static  final Item NYX = registerItem("nyx", new Item(new FabricItemSettings()));
    public  static  final Item KEN_INGOT = registerItem("ken_ingot", new Item(new FabricItemSettings()));

    public  static  final Item JETPACK_HELLRIDE_MUSIC_DISC = registerItem("jetpack_hellride_music_disc", //EPIC MUSIC DISK YIPEEE
            new MusicDiscItem(7, ModSounds.JETPACK_HELLRIDE,new  FabricItemSettings().maxCount(1),155));
    public  static  final Item KEN_WAITING_FOR_LOVE_MUSIC_DISC = registerItem("ken_waiting_for_love_music_disc", //EPIC MUSIC DISK YIPEEE
            new MusicDiscItem(7, ModSounds.KEN_WAITING_FOR_LOVE,new  FabricItemSettings().maxCount(1),227));
    public  static  final Item CANT_GO_TO_HELL_MUSIC_DISC = registerItem("cant_go_to_hell_music_disc", //EPIC MUSIC DISK YIPEEE
            new MusicDiscItem(7, ModSounds.CANT_GO_TO_HELL,new  FabricItemSettings().maxCount(1),211));



    public  static  final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public  static  final Item KEN_STAFF = registerItem("ken_staff",
            new Item(new FabricItemSettings().maxCount(1)));


    public  static  final Item KEN_PICKAXE = registerItem("ken_pickaxe",
            new PickaxeItem(ModToolMaterial.KEN_INGOT, 2,2f,
                    new FabricItemSettings().maxCount(1)));

    public  static  final Item KEN_AXE = registerItem("ken_axe",
            new AxeItem(ModToolMaterial.KEN_INGOT, 15,1.2f,
                    new FabricItemSettings().maxCount(1)));

    public  static  final Item KEN_SHOVEL = registerItem("ken_shovel",
            new ShovelItem(ModToolMaterial.KEN_INGOT, 2,2f,
                    new FabricItemSettings().maxCount(1)));

    public  static  final Item KEN_HOE = registerItem("ken_hoe",
            new HoeItem(ModToolMaterial.KEN_INGOT, 2,2f,
                    new FabricItemSettings().maxCount(1)));

    public  static  final Item KEN_SWORD = registerItem("ken_sword",
            new SwordItem(ModToolMaterial.KEN_INGOT, 11,2f,
                    new FabricItemSettings().maxCount(1)));




    public  static  final Item KEN_HELMET = registerItem("ken_helmet",
            new ModArmorItem(ModArmourMaterials.KEN_INGOT, ArmorItem.Type.HELMET, new  FabricItemSettings()));
    public  static  final Item KEN_CHESTPLATE = registerItem("ken_chestplate",
            new ArmorItem(ModArmourMaterials.KEN_INGOT, ArmorItem.Type.CHESTPLATE, new  FabricItemSettings()));
    public  static  final Item KEN_LEGGINGS = registerItem("ken_leggings",
            new ArmorItem(ModArmourMaterials.KEN_INGOT, ArmorItem.Type.LEGGINGS, new  FabricItemSettings()));
    public  static  final Item KEN_BOOTS = registerItem("ken_boots",
            new ArmorItem(ModArmourMaterials.KEN_INGOT, ArmorItem.Type.BOOTS, new  FabricItemSettings()));



    public static final Item DICE = registerItem("dice",new DiceItem(new FabricItemSettings()));

    public static final Item BULLET = registerItem("bullet",new BulletItem(new FabricItemSettings().maxCount(30)));
    public static final Item SNIPER_BULLET = registerItem("sniper_bullet",new BulletItem(new FabricItemSettings().maxCount(6)));

    public  static  final Item GUN = registerItem("gun",
            new ARItem(new FabricItemSettings().maxCount(1)));

    public  static  final Item SNIPER = registerItem("sniper",
            new SniperItem(new FabricItemSettings().maxCount(1)));



    public  static  final Item PIEROGI = registerItem
            ("pierogi", new Item(new FabricItemSettings().food(ModFoodComponents.PIEROGI)));

    public  static  final Item VODKA = registerItem
            ("vodka", new Item(new FabricItemSettings().food(ModFoodComponents.VODKA)));

    public  static  final Item MEAT_BALLS = registerItem
            ("meat_balls", new Item(new FabricItemSettings().food(ModFoodComponents.MEAT_BALLS)));


    public static final Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE,0xa86518,0x3b260f, new FabricItemSettings()));


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
