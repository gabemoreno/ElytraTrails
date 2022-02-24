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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class GUI extends Menu{

    private final Player player;
    private final Inventory inventory = getInventory();
    //private final int[] innerSlots = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};
    private final int[] innerSlots = new int[]{10, 11, 12};


    private final int rightSlot = 50;
    private final int leftSlot = 48;
    private final int pageSlot = 49;

    private final ItemStack rightButton = ItemUtil.getSkull(ChatColor.GREEN + "" + ChatColor.BOLD + "Next", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFkMGY4MmEyYTRjZGQ4NWY3OWY0ZDlkOTc5OGY5YzNhNWJjY2JlOWM3ZjJlMjdjNWZjODM2NjUxYThmM2Y0NSJ9fX0=");
    private final ItemStack leftButton = ItemUtil.getSkull(ChatColor.RED + "" + ChatColor.BOLD + "Back", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWRmNWMyZjg5M2JkM2Y4OWNhNDA3MDNkZWQzZTQyZGQwZmJkYmE2ZjY3NjhjODc4OWFmZGZmMWZhNzhiZjYifX19");



    private int pageNumber = 1;

    private final List<List<TrailType>> partitions = MenuUtil.partitionBasedOnSize(Arrays.asList(TrailType.values()), innerSlots.length).stream().toList();


    public GUI(Player player) {
        super(player, 6, MenuUtil.getPluginGradientName());
        this.player = player;
        build();
        open();
    }

    public void build() {
        prepItems();
        //updateEquipped();
    }

    private void prepItems() {
        fillBackground();
        inventory.setItem(pageSlot, new ItemStack(Material.MAP));
        inventory.setItem(leftSlot, leftButton);
        inventory.setItem(rightSlot, rightButton);
        updatePage();
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        Player clicked = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType() == Material.AIR) return;

        if (event.getSlot() == rightSlot) {
            if (pageNumber == partitions.size()) return;
            pageNumber++;
            updatePage();
            return;
        }

        if (event.getSlot() == leftSlot) {
            if (pageNumber == 1) return;
            pageNumber--;
            updatePage();
            return;
        }



        if (!TrailUtil.isGUITrail(item)) return;
        TrailType trail = TrailUtil.getTrailFromGUI(item);
        //Player unequipping trail
        if (trail.name().equals(TrailUtil.getActiveTrailID(clicked))) {
            TrailUtil.removeTrail(clicked);
            clicked.sendMessage(MenuUtil.getPluginPrefix() + ChatColor.DARK_GRAY + "Unequipped the " + item.getItemMeta().getDisplayName() + ChatColor.DARK_GRAY + ".");
            updatePage();
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
        updatePage();
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

    public void fillBackground() {
        for (int i = 0 ; i < inventory.getSize(); i++) {
            inventory.setItem(i, ItemUtil.makeItem(Material.PURPLE_STAINED_GLASS_PANE, ChatColor.WHITE + ""));
        }
    }

    public void clearInnerSlots(){
        for (int i = 0 ; i < innerSlots.length ; i++) {
            inventory.setItem(innerSlots[i], null);
        }
    }

    public void updatePage() {
        clearInnerSlots();
        List<TrailType> pageContents = partitions.get(pageNumber-1);

        //Pastes page contents into the inner slots, enchanting the item if it is an equipped trail
        for (int i = 0 ; i < pageContents.size() ; i++ ) {
            TrailType trail = pageContents.get(i);
            int slot = innerSlots[i];
            inventory.setItem(slot, ItemUtil.addLore(trail.getDisplayItem(), (getPlayer().hasPermission(trail.getPermission()) ? ChatColor.GREEN + "☑" : ChatColor.RED + "☒") + ChatColor.GRAY + " Owned?"));
            ItemStack item = inventory.getItem(slot);
            if (!TrailUtil.getTrailFromGUI(item).equals(TrailUtil.getActiveTrail(getPlayer()))) continue;
            item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        }

        //Updating the page number
        ItemStack page = inventory.getItem(pageSlot);
        ItemMeta pageMeta = page.getItemMeta();
        pageMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7(" + pageNumber + "/" + partitions.size() + ")"));
        page.setItemMeta(pageMeta);
        page.setAmount(pageNumber);
    }
}
