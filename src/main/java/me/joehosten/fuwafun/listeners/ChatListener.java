package me.joehosten.fuwafun.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String perm = "fuwafun.chat.";
        if (p.hasPermission(perm + "sumi")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&c&lSUMI&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
            return;
        } else if (p.hasPermission(perm + "asuka")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&6&lASUKA&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
            return;
        }
        if (p.hasPermission(perm + "shinji")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&7&lSHINJI&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
            return;
        }
        if (p.hasPermission(perm + "simp")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&5&lSIMP&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
            return;
        }
        if (p.hasPermission(perm + "ritsu")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&e&lRITSU&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
            return;
        }
        if (p.hasPermission(perm + "mio")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&8[&3&lMIO&8]&7 " + e.getPlayer().getName() + ": " + e.getMessage()));
        } else {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&7" + e.getPlayer().getName() + ": " + e.getMessage()));
        }
    }
}
