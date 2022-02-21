package me.gabriel.elytratrails.commands;

import me.gabriel.elytratrails.menus.GUI;
import me.gabriel.elytratrails.menus.Menu;
import me.gabriel.elytratrails.util.MenuUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ElytraTrailsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command may not be run from the console.");
            return true;
        }
        Player player = (Player) sender;
        Menu gui = new GUI(player);
        if (!MenuUtil.getMenus().contains(player)) {
            MenuUtil.getMenus().add(gui);
        }
        return true;
    }
}
