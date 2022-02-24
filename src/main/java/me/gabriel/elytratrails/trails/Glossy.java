package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

public class Glossy extends Trail{
    public Glossy() {
        super(
                ItemUtil.makeItem(Material.LIME_GLAZED_TERRACOTTA, ChatColor.GREEN + "Glossy Trail"),
                new Material[] {Material.LIGHT_GRAY_GLAZED_TERRACOTTA, Material.GRAY_GLAZED_TERRACOTTA, Material.PINK_GLAZED_TERRACOTTA, Material.LIGHT_BLUE_GLAZED_TERRACOTTA, Material.LIME_GLAZED_TERRACOTTA, Material.YELLOW_GLAZED_TERRACOTTA, Material.ORANGE_GLAZED_TERRACOTTA, Material.WHITE_GLAZED_TERRACOTTA, Material.MAGENTA_GLAZED_TERRACOTTA, Material.RED_GLAZED_TERRACOTTA, Material.GREEN_GLAZED_TERRACOTTA, Material.BROWN_GLAZED_TERRACOTTA, Material.BLUE_GLAZED_TERRACOTTA, Material.PURPLE_GLAZED_TERRACOTTA, Material.CYAN_GLAZED_TERRACOTTA},
                new Particle[] {Particle.FIREWORKS_SPARK},
                new SoundEffect[] {});
    }
}
