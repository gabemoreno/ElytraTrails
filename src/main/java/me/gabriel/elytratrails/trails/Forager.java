package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;

public class Forager extends Trail {

    public Forager() {
        super(
                ItemUtil.makeItem(Material.CRIMSON_FUNGUS, ChatColor.RED + "Forager Trail"),
                new Material[] {Material.RED_MUSHROOM, Material.BROWN_MUSHROOM, Material.CRIMSON_FUNGUS, Material.WARPED_FUNGUS, Material.DEAD_BUSH,Material.FERN, Material.CRIMSON_ROOTS, Material.KELP, Material.MEDIUM_AMETHYST_BUD, Material.SWEET_BERRIES, Material.GLOW_BERRIES},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {}
        );
    }

}
