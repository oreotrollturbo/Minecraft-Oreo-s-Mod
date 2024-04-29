package net.oreotroll.tutorialmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.oreotroll.tutorialmod.TutorialMod;

import java.text.BreakIterator;

public class ModSounds { //I have added quite a few sounds

    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static final SoundEvent SOUND_BLOCK_BREAK = registerSoundEvent("sound_block_break");
    public static final SoundEvent SOUND_BLOCK_STEP = registerSoundEvent("sound_block_step");
    public static final SoundEvent SOUND_BLOCK_PLACE = registerSoundEvent("sound_block_place");
    public static final SoundEvent SOUND_BLOCK_HIT = registerSoundEvent("sound_block_hit");
    public static final SoundEvent SOUND_BLOCK_FALL = registerSoundEvent("sound_block_fall");

    public static final SoundEvent SOUND_BULLET_SHOOT = registerSoundEvent("sound_bullet_shoot");
    public static final SoundEvent SOUND_SNIPER_BULLET_SHOOT = registerSoundEvent("sound_sniper_bullet_shoot");
    public static final SoundEvent SOUND_GUN_DRY_FIRE = registerSoundEvent("sound_gun_dry_fire");
    public static final SoundEvent SOUND_RAIL_GUN_SHOT = registerSoundEvent("sound_rail_gun_shot");
    public static final SoundEvent SOUND_RAIL_GUN_WINDUP = registerSoundEvent("sound_rail_gun_windup");
    public static final SoundEvent SOUND_RAIL_GUN_WINDOWN = registerSoundEvent("sound_rail_gun_windown");

    public static final SoundEvent JETPACK_HELLRIDE = registerSoundEvent("jetpack_hellride"); // All of these are bangers
    public static final SoundEvent KEN_WAITING_FOR_LOVE = registerSoundEvent("ken_waiting_for_love");
    public static final SoundEvent CANT_GO_TO_HELL = registerSoundEvent("cant_go_to_hell");

    public static final BlockSoundGroup SOUND_BLOCK_SOUNDS = new BlockSoundGroup(1f,1f,
            ModSounds.SOUND_BLOCK_BREAK,ModSounds.SOUND_BLOCK_STEP,ModSounds.SOUND_BLOCK_PLACE,
            ModSounds.SOUND_BLOCK_HIT,ModSounds.SOUND_BLOCK_FALL);



    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id,SoundEvent.of(id));

    }


    public static void registerSounds(){
        TutorialMod.LOGGER.info("Registering Sounds for " + TutorialMod.MOD_ID);
    }

}
