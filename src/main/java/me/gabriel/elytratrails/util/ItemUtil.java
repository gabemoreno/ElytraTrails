package me.gabriel.elytratrails.util;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import me.gabriel.elytratrails.ElytraTrails;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.UUID;

public class ItemUtil {

    private static NamespacedKey getFrequencyKey() {
        return new NamespacedKey(ElytraTrails.getInstance(), "frequency");
    }

    public static ItemStack getFrequencyItem(Material material, int frequency) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(getFrequencyKey(), PersistentDataType.INTEGER, frequency);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static int getItemFrequency(ItemStack itemStack) {
        return itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(getFrequencyKey(), PersistentDataType.INTEGER, 1);
    }

    public static ItemStack makeItem(Material material, String displayName, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addLore(ItemStack item, String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSkull(String name, String texture) {
        ItemStack skull= new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

        if (texture == null || texture.isEmpty())
            return skull;

        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();

        skullMeta.setPlayerProfile(Bukkit.createProfile(UUID.randomUUID(), null));

        PlayerProfile profile = skullMeta.getPlayerProfile();

        profile.getProperties().add(new ProfileProperty("textures", texture));

        skullMeta.setPlayerProfile(profile);
        skullMeta.setDisplayName(name);
        skull.setItemMeta(skullMeta);
        return skull;
    }
}
