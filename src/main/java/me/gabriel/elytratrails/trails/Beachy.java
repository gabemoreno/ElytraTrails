package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

public class Beachy extends Trail {
    public Beachy() {
        super(
                ItemUtil.makeItem(Material.TOTEM_OF_UNDYING, ChatColor.YELLOW + "Beachy Trail"),
                new Material[] {Material.CACTUS, Material.SAND, Material.TROPICAL_FISH, Material.PUFFERFISH, Material.ORANGE_GLAZED_TERRACOTTA, Material.BRAIN_CORAL, Material.HORN_CORAL, Material.TURTLE_EGG, Material.PRISMARINE_CRYSTALS, Material.PRISMARINE_SHARD, Material.NAUTILUS_SHELL, Material.TOTEM_OF_UNDYING, Material.SEA_PICKLE, Material.KELP, Material.SEAGRASS},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {new SoundEffect(new SoundComponent(Sound.ENTITY_AXOLOTL_SWIM)), new SoundEffect(new SoundComponent(Sound.ENTITY_PARROT_AMBIENT)),new SoundEffect(new SoundComponent(Sound.ENTITY_TURTLE_EGG_HATCH)),new SoundEffect(Scale.MAJOR, 6, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_COW_BELL, 0.5F, .8f), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_FLUTE, 0.5F, .8f))});
    }
}
