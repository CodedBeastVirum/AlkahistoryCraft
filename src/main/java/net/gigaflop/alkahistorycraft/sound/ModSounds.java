package net.gigaflop.alkahistorycraft.sound;

import net.gigaflop.alkahistorycraft.AlkahistoryCraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AlkahistoryCraft.MODID);

    public static final Supplier<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_used");

    public static final Supplier<SoundEvent> CRYSTAL_BLOCK_BREAK = registerSoundEvent("crystal_block_break");
    public static final Supplier<SoundEvent> CRYSTAL_BLOCK_STEP = registerSoundEvent("crystal_block_step");
    public static final Supplier<SoundEvent> CRYSTAL_BLOCK_PLACE = registerSoundEvent("crystal_block_place");
    public static final Supplier<SoundEvent> CRYSTAL_BLOCK_HIT = registerSoundEvent("crystal_block_hit");
    public static final Supplier<SoundEvent> CRYSTAL_BLOCK_FALL = registerSoundEvent("crystal_block_fall");

    public static final DeferredSoundType CRYSTAL_BLOCK_SOUNDS = new DeferredSoundType(1f, 1f,
            ModSounds.CRYSTAL_BLOCK_BREAK,
            ModSounds.CRYSTAL_BLOCK_STEP,
            ModSounds.CRYSTAL_BLOCK_PLACE,
            ModSounds.CRYSTAL_BLOCK_HIT,
            ModSounds.CRYSTAL_BLOCK_FALL);

    public static final Supplier<SoundEvent> BAR_BRAWL = registerSoundEvent("bar_brawl");
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = createSong("bar_brawl");

    private static ResourceKey<JukeboxSong> createSong (String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(AlkahistoryCraft.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
