package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Party extends Trail {

    public Party() {
        super(
                ItemUtil.makeItem(Material.AMETHYST_SHARD, ChatColor.LIGHT_PURPLE + "Party Trail"),
                new Material[] {Material.AMETHYST_SHARD, Material.DIAMOND, Material.GOLD_NUGGET, Material.IRON_NUGGET, Material.NETHER_STAR, Material.EMERALD, Material.LAPIS_LAZULI, Material.GLOW_INK_SAC, Material.REDSTONE, Material.SUNFLOWER},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {new SoundEffect(Scale.MAJOR, 1, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_FLUTE, 2, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_CHIME, 2, 1))});
    }

}
