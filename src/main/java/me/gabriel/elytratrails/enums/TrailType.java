package me.gabriel.elytratrails.enums;

import me.gabriel.elytratrails.trails.*;
import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public enum TrailType {

    FEAST(new Feast()), FORAGER(new Forager()), WOODLAND(new Woodland()), PARTY(new Party()), FROST(new Frost());

    private final Trail trail;

    TrailType(Trail trail) {
        this.trail = trail;
    }

    public void dropRandomItem(Player player) {
        trail.dropItem(player);
    }

    public void spawnRandomParticle(Player player) {
        trail.spawnParticle(player);
    }

    public void playRandomSound(Player player) {
        trail.playSound(player);
    }

    public ItemStack getDisplayItem() {
        return TrailUtil.makeGUITrail(trail.getDisplayItem(), this);
    }

    public String getPermission() {
        return "elytratrails.trail." + name().toLowerCase();
    }

}
