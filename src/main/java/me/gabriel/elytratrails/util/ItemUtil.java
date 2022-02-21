package me.gabriel.elytratrails.util;

import me.gabriel.elytratrails.ElytraTrails;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

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
}
