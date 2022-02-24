package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Egg extends Trail{
    public Egg() {
        super(
                ItemUtil.makeItem(Material.SHEEP_SPAWN_EGG, ChatColor.WHITE + "Egg Trail"),
                new Material[] {Material.PIG_SPAWN_EGG, Material.PUFFERFISH_SPAWN_EGG, Material.SALMON_SPAWN_EGG, Material.PHANTOM_SPAWN_EGG, Material.PARROT_SPAWN_EGG, Material.DROWNED_SPAWN_EGG, Material.DOLPHIN_SPAWN_EGG, Material.BLAZE_SPAWN_EGG, Material.AXOLOTL_SPAWN_EGG, Material.SQUID_SPAWN_EGG, Material.SLIME_SPAWN_EGG, Material.SHEEP_SPAWN_EGG, Material.SHULKER_SPAWN_EGG, Material.TRADER_LLAMA_SPAWN_EGG, Material.ZOGLIN_SPAWN_EGG, Material.ZOMBIE_SPAWN_EGG, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, Material.TROPICAL_FISH_SPAWN_EGG, Material.MOOSHROOM_SPAWN_EGG, Material.STRIDER_SPAWN_EGG, Material.TURTLE_SPAWN_EGG, Material.STRAY_SPAWN_EGG},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {new SoundEffect(new SoundComponent(Sound.ENTITY_CHICKEN_EGG)), new SoundEffect(Scale.MAJOR, 3, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_BANJO, 0.4F, .8f), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_HARP, 0.5F, .8f))});
    }
}
