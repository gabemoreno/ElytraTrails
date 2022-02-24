package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

public class Floral extends Trail {

    public Floral() {
        super(
                ItemUtil.makeItem(Material.PEONY, ChatColor.LIGHT_PURPLE + "Floral Trail"),
                new Material[] {Material.PINK_TULIP, Material.WHITE_TULIP, Material.RED_TULIP, Material.AZURE_BLUET, Material.BLUE_ORCHID, Material.ORANGE_TULIP, Material.ALLIUM, Material.DANDELION, Material.POPPY, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.LILAC, Material.ROSE_BUSH, Material.SUNFLOWER, Material.PEONY, Material.JUNGLE_LEAVES, Material.JUNGLE_LEAVES, Material.JUNGLE_LEAVES, Material.JUNGLE_LEAVES},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {});
    }
}
