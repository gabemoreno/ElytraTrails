package me.gabriel.elytratrails.util;

import me.gabriel.elytratrails.ElytraTrails;
import me.gabriel.elytratrails.enums.TrailType;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrailUtil {

    /* Active Trails */

    //Trail items will spawn at the location of every player in this list
    private static List<Player> activeTrailers = new ArrayList<Player>();

    public static List<Player> getActiveTrailers() {
        return activeTrailers;
    }

    private static NamespacedKey getActiveTrailIDKey() {
        return new NamespacedKey(ElytraTrails.getInstance(), "active-trail-id");
    }

    public static String getActiveTrailID(Player player) {
        return player.getPersistentDataContainer().getOrDefault(getActiveTrailIDKey(), PersistentDataType.STRING, "none");
    }

    private static void setActiveTrailID(Player player, String string) {
        player.getPersistentDataContainer().set(getActiveTrailIDKey(), PersistentDataType.STRING, string);
    }

    public static void setActiveTrail(Player player, TrailType trail) {
        player.getPersistentDataContainer().set(getActiveTrailIDKey(), PersistentDataType.STRING, trail.name());
    }

    public static boolean hasActiveTrail(Player player) {
        return Arrays.stream(TrailType.values()).map(Enum::name).collect(Collectors.toList()).contains(getActiveTrailID(player));
    }

    public static TrailType getActiveTrail(Player player) {
        return TrailType.valueOf(getActiveTrailID(player));
    }

    public static void removeTrail(Player player) {
        setActiveTrailID(player, "none");
        activeTrailers.remove(player);
    }

    /* Trail Items */

    //Key used to identify items spawned from trails to prevent pickup, hoppers, etc.
    public static NamespacedKey getTrailItemKey() {
        return new NamespacedKey(ElytraTrails.getInstance(), "trail-item");
    }

    public static boolean isTrailItem(Item item) {
        return item.getPersistentDataContainer().has(getTrailItemKey(), PersistentDataType.INTEGER);
    }

    public static void makeTrailItem(Item item) {
        item.getPersistentDataContainer().set(getTrailItemKey(), PersistentDataType.INTEGER, 1);
        item.setCanMobPickup(false);
        item.setCanPlayerPickup(false);
        item.setTicksLived(6000-18);
    }


    /* Trail GUI Items */

    //Uses same key as dropped trail items
    public static ItemStack makeGUITrail(ItemStack item, TrailType trail) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(getTrailItemKey(), PersistentDataType.STRING, trail.name());
        item.setItemMeta(meta);
        return item;
    }

    //Only Trail enum displayItems will have this
    public static boolean isGUITrail(ItemStack item) {
        return item.getItemMeta().getPersistentDataContainer().has(getTrailItemKey(), PersistentDataType.STRING);
    }

    public static TrailType getTrailFromGUI(ItemStack item) {
        return TrailType.valueOf(item.getItemMeta().getPersistentDataContainer().get(getTrailItemKey(), PersistentDataType.STRING));
    }

}
