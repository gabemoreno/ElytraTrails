package me.gabriel.elytratrails.trailcomponents;

import me.gabriel.elytratrails.enums.Scale;
import org.bukkit.Location;
import org.bukkit.Particle;

public class SoundEffect {

    private final int frequency;
    private final SoundComponent[] sounds;
    private final boolean isMusic;
    private Scale scale = null;

    public SoundEffect(SoundComponent trailSound) {
        this.frequency = 1;
        this.sounds = new SoundComponent[] {trailSound};
        this.isMusic = false;
    }

    public SoundEffect(Scale scale, SoundComponent trailSound) {
        this.frequency = 1;
        this.sounds = new SoundComponent[] {trailSound};
        this.isMusic = true;
        this.scale = scale;
    }

    public SoundEffect(int frequency, SoundComponent trailSound) {
        this.frequency = frequency;
        this.sounds = new SoundComponent[] {trailSound};
        this.isMusic = false;
    }

    public SoundEffect(Scale scale, int frequency, SoundComponent trailSound) {
        this.frequency = frequency;
        this.sounds = new SoundComponent[] {trailSound};
        this.isMusic = true;
        this.scale = scale;
    }

    public SoundEffect(SoundComponent... trailSounds) {
        this.frequency = 1;
        this.sounds = trailSounds;
        this.isMusic = false;
    }

    public SoundEffect(Scale scale, SoundComponent... trailSounds) {
        this.frequency = 1;
        this.sounds = trailSounds;
        this.isMusic = true;
        this.scale = scale;
    }

    public SoundEffect(int frequency, SoundComponent... trailSounds) {
        this.frequency = frequency;
        this.sounds = trailSounds;
        this.isMusic = false;
    }

    public SoundEffect(Scale scale, int frequency, SoundComponent... trailSounds) {
        this.frequency = frequency;
        this.sounds = trailSounds;
        this.isMusic = true;
        this.scale = scale;
    }

    public int getFrequency() {
        return frequency;
    }

    public void play(Location location) {
        if (scale == null) {
            for (SoundComponent sound : sounds) {
                location.getWorld().playSound(location, sound.getSound(), sound.getVolume(), sound.getPitch());
            }
            return;
        }
        float pitch = scale.getRandomPitch();
        location.getWorld().spawnParticle(Particle.NOTE, location, 1);
        for (SoundComponent sound : sounds) {
            location.getWorld().playSound(location, sound.getSound(), sound.getVolume(), pitch);
        }

    }

}
