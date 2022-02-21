package me.gabriel.elytratrails.trailcomponents;

import org.bukkit.Sound;

public class SoundComponent {

    private final Sound sound;
    private final float volume;
    private final float pitch;

    public SoundComponent(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public SoundComponent(Sound sound) {
        this.sound = sound;
        this.volume = 2;
        this.pitch = 1;
    }

    public Sound getSound() {
        return sound;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }


}
