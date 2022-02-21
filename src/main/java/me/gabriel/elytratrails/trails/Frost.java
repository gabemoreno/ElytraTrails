package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Frost extends Trail{
    public Frost() {
        super(
                ItemUtil.makeItem(Material.SNOWBALL, ChatColor.AQUA + "Frost Trail"),
                new Material[] {Material.SNOWBALL, Material.SNOWBALL, Material.SNOWBALL, Material.ICE, Material.BLUE_DYE, Material.LIGHT_BLUE_DYE, Material.LIGHT_BLUE_CONCRETE_POWDER, Material.LIGHT_BLUE_GLAZED_TERRACOTTA, Material.NETHER_STAR},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {new SoundEffect(new SoundComponent(Sound.BLOCK_SNOW_PLACE)), new SoundEffect(new SoundComponent(Sound.BLOCK_AMETHYST_BLOCK_STEP)),
                        new SoundEffect(Scale.MINOR, 2, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 0.5F, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5F, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_HARP, 0.5F, 1))});
    }
}
