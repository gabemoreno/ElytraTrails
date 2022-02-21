package me.gabriel.elytratrails.listeners;

import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class ElytraFlightListener implements Listener {

    @EventHandler
    public void onFlight(EntityToggleGlideEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) return;
        Player player = (Player)  event.getEntity();

        if (!TrailUtil.hasActiveTrail(player)) return;

        if (event.isGliding()) {
            if (!TrailUtil.getActiveTrailers().contains(player)) TrailUtil.getActiveTrailers().add(player);
            return;
        }
        TrailUtil.getActiveTrailers().remove(player);
    }
}
