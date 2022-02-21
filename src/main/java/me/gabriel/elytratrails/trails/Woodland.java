package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Woodland extends Trail {

    public Woodland() {
        super(
                ItemUtil.makeItem(Material.OAK_SAPLING, ChatColor.DARK_GREEN + "Woodland Trail"),
                new Material[] {Material.BIRCH_LEAVES, Material.OAK_LEAVES, Material.FLOWERING_AZALEA_LEAVES, Material.FLOWERING_AZALEA_LEAVES, Material.JUNGLE_LEAVES, Material.SPRUCE_LEAVES, Material.OAK_SAPLING, Material.JUNGLE_SAPLING, Material.SPRUCE_SAPLING, Material.BIRCH_SAPLING, Material.DARK_OAK_SAPLING, Material.ACACIA_SAPLING, Material.STICK, Material.STICK, Material.STICK, Material.STICK, Material.SPORE_BLOSSOM, Material.SPORE_BLOSSOM},
                new Particle[] {Particle.FIREWORKS_SPARK, Particle.SPORE_BLOSSOM_AIR},
                new SoundEffect[] {new SoundEffect(new SoundComponent(Sound.BLOCK_GRASS_FALL)), new SoundEffect(new SoundComponent(Sound.BLOCK_MOSS_BREAK)), new SoundEffect(new SoundComponent(Sound.BLOCK_AZALEA_LEAVES_PLACE)),
                        new SoundEffect(Scale.MAJOR, 2, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_BELL, 0.5F, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5F, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_HARP, 0.5F, 1))}
        );
    }

}
