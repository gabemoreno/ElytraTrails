package me.gabriel.elytratrails.listeners;

import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class InventoryPickupItemListener implements Listener {
    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        if (!TrailUtil.isTrailItem(event.getItem())) return;
        event.setCancelled(true);
    }
}
