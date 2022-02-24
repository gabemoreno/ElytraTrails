package me.gabriel.elytratrails;

import me.gabriel.elytratrails.commands.ElytraTrailsCommand;
import me.gabriel.elytratrails.listeners.ElytraFlightListener;
import me.gabriel.elytratrails.listeners.InventoryListener;
import me.gabriel.elytratrails.listeners.InventoryPickupItemListener;
import me.gabriel.elytratrails.menus.Menu;
import me.gabriel.elytratrails.util.MenuUtil;
import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.vanish.VanishManager;
import org.kitteh.vanish.VanishPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ElytraTrails extends JavaPlugin {

    private static ElytraTrails instance;

    private final List<Supplier<Listener>> listeners = Arrays.asList(ElytraFlightListener::new, InventoryPickupItemListener::new, InventoryListener::new);
    private VanishManager manager;
    @Override
    public void onEnable() {
        instance = this;
        manager = ((VanishPlugin) Bukkit.getPluginManager().getPlugin("VanishNoPacket")).getManager();
        listeners.forEach(listener -> Bukkit.getPluginManager().registerEvents(listener.get(), this));
        getCommand("elytratrails").setExecutor(new ElytraTrailsCommand());

        //Item Drop Trail
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (manager == null) return;
            if (TrailUtil.getActiveTrailers().isEmpty()) return;
            TrailUtil.getActiveTrailers().stream().filter(Predicate.not(manager::isVanished))
                    .forEach(player -> TrailUtil.getActiveTrail(player).dropRandomItem(player));
        }, 0, 1L);

        //Particle and Sound Trail
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (TrailUtil.getActiveTrailers().isEmpty()) return;
            TrailUtil.getActiveTrailers().stream().filter(Predicate.not(manager::isVanished)).forEach(player -> {
                TrailUtil.getActiveTrail(player).playRandomSound(player);
                TrailUtil.getActiveTrail(player).spawnRandomParticle(player);
            });
        }, 0, 5L);

        getLogger().info(ChatColor.LIGHT_PURPLE + "Elytra Trails is now enabled");

    }

    @Override
    public void onDisable() {
        if (MenuUtil.getMenus().isEmpty()) return;
        MenuUtil.getMenus().stream().map(Menu::getPlayer).filter(player -> player != null && player.getOpenInventory().getTopInventory().getHolder() instanceof Menu).forEach(HumanEntity::closeInventory);
    }

    public static ElytraTrails getInstance() {
        return instance;
    }

}
