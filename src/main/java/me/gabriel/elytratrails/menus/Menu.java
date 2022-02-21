package me.gabriel.elytratrails.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu implements InventoryHolder {

    private final static List<Player> viewers = new ArrayList<>();
    private final Inventory inventory;
    private final Player player;

    public Menu(Player player, int rows, String title) {
        viewers.add(player);
        inventory = Bukkit.createInventory(this, rows*9, title);
        this.player = player;
    }

    public List<Player> getViewersList(){
        return viewers;
    }
    //test

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract void build();
    public abstract void onClick(InventoryClickEvent event);
    public abstract void onClose(InventoryCloseEvent event);

    public void open() {
        player.openInventory(inventory);
    }

    public void close() {
        viewers.remove(player);
        player.closeInventory();
    }

    public static void onDisable() {
        viewers.forEach(Player::closeInventory);
    }
}