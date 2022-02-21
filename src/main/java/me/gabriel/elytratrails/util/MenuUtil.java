package me.gabriel.elytratrails.util;

import me.gabriel.elytratrails.menus.Menu;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    private static final List<Menu> menus = new ArrayList<Menu>();

    public static List<Menu> getMenus() {
        return menus;
    }

    public static String getPluginPrefix() {
        String[] colors = new String[] {"#a746ca", "#af51ce", "#a746ca", "#af51ce", "#b85bd3", "#c065d7", "#c86fdc", "#cf7ae1", "#d784e5", "#de8eea", "#e698ef", "#eda2f4"};
        String[] letters = new String[] {"E", "l", "y", "t", "r", "a", "T", "r", "a", "i", "l", "s"};
        String prefix = ChatColor.GRAY + "[";
        for (int i = 0 ; i < colors.length ; i++) {
            prefix += net.md_5.bungee.api.ChatColor.of(colors[i]) + letters[i];
        }
        prefix += ChatColor.GRAY + "] ";
        return prefix;
    }

    public static String getPluginGradientName() {
        String[] colors = new String[] {"#a746ca", "#af51ce", "#a746ca", "#af51ce", "#b85bd3", "#c065d7", "#c86fdc", "#cf7ae1", "#d784e5", "#de8eea", "#e698ef", "#eda2f4"};
        String[] letters = new String[] {"E", "l", "y", "t", "r", "a", "T", "r", "a", "i", "l", "s"};
        String prefix = ChatColor.GRAY + "" + ChatColor.BOLD + "• • • • • ";
        for (int i = 0 ; i < colors.length ; i++) {
            prefix += net.md_5.bungee.api.ChatColor.of(colors[i]) + "" + ChatColor.BOLD + letters[i];
        }
        prefix += ChatColor.GRAY + "" + " • • • • •";
        return prefix;
    }

}
