package me.gabriel.elytratrails.menus;

import me.gabriel.elytratrails.enums.TrailType;
import me.gabriel.elytratrails.util.ItemUtil;
import me.gabriel.elytratrails.util.MenuUtil;
import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class GUI extends Menu{

    private final Player player;
    private final Inventory inventory = getInventory();

    public GUI(Player player) {
        super(player, 1, "Elytra Trails");
        this.player = player;
        build();
        open();
    }

    public void build() {
        prepItems();
        updateEquipped();
    }

    private void prepItems() {
        for (int i = 0; i < TrailType.values().length ; i++) {
            TrailType trail = TrailType.values()[i];
            inventory.setItem(i, ItemUtil.addLore(trail.getDisplayItem(), (getPlayer().hasPermission(trail.getPermission()) ? ChatColor.GREEN + "☑" : ChatColor.RED + "☒") + ChatColor.GRAY + " Owned?"));
        }
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        Player clicked = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType() == Material.AIR) return;
        if (!TrailUtil.isGUITrail(item)) return;
        TrailType trail = TrailUtil.getTrailFromGUI(item);
        //Player unequipping trail
        if (trail.name().equals(TrailUtil.getActiveTrailID(clicked))) {
            TrailUtil.removeTrail(clicked);
            clicked.sendMessage(MenuUtil.getPluginPrefix() + ChatColor.DARK_GRAY + "Unequipped the " + item.getItemMeta().getDisplayName() + ChatColor.DARK_GRAY + ".");
            updateEquipped();
            return;
        }
        //Player equipping trail
        if (!clicked.hasPermission(trail.getPermission())) {
            clicked.sendMessage(MenuUtil.getPluginPrefix() + ChatColor.RED + "Sorry! You don't own the " + item.getItemMeta().getDisplayName() + ChatColor.RED + ".");
            return;
        }
        TrailUtil.setActiveTrail(clicked, trail);
        if (clicked.isGliding()) if (!TrailUtil.getActiveTrailers().contains(clicked)) TrailUtil.getActiveTrailers().add(clicked);
        clicked.sendMessage(MenuUtil.getPluginPrefix() + ChatColor.GREEN + "Equipped the " + item.getItemMeta().getDisplayName() + ChatColor.GREEN + ".");
        updateEquipped();
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        MenuUtil.getMenus().remove(this);
    }

    @Override
    public void close() {
        getViewersList().remove(player);
        player.closeInventory();
        MenuUtil.getMenus().remove(this);
    }

    public void updateEquipped() {
        for (ItemStack item : inventory.getContents()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (!TrailUtil.isGUITrail(item)) return;
            if (TrailUtil.getTrailFromGUI(item).name().equals(TrailUtil.getActiveTrailID(getPlayer()))) {
                item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            } else {
                item.removeEnchantment(Enchantment.DURABILITY);
            }
        }
    }
}
