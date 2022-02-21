package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.enums.Scale;
import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.trailcomponents.SoundComponent;
import me.gabriel.elytratrails.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class Feast extends Trail {

            public Feast() {
            super(
                    ItemUtil.makeItem(Material.COOKED_CHICKEN, ChatColor.GOLD + "Feast Trail"),
                    new Material[] {Material.SWEET_BERRIES, Material.BEETROOT_SOUP, Material.CARROT, Material.GOLDEN_CARROT, Material.BAKED_POTATO, Material.BREAD, Material.GLOW_BERRIES,
                            Material.BEETROOT, Material.COOKED_CHICKEN, Material.PUMPKIN_PIE, Material.RABBIT_STEW, Material.MUSHROOM_STEW},
                    new Particle[] {Particle.FIREWORKS_SPARK},
                    new SoundEffect[] {new SoundEffect(5, new SoundComponent(Sound.ENTITY_GENERIC_EAT)), new SoundEffect(new SoundComponent(Sound.ENTITY_PLAYER_BURP)), new SoundEffect(Scale.MINOR, 5, new SoundComponent(Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.5F, 1), new SoundComponent(Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1))}
            );
    }

}
