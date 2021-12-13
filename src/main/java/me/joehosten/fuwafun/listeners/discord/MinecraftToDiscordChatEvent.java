package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MinecraftToDiscordChatEvent implements Listener {

    private final FuwaFun plugin;

    public MinecraftToDiscordChatEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.getMessage().contains("@everyone") || e.getMessage().contains("@here") || e.getMessage().contains("@dj") || e.getMessage().contains("@admin")) {
            e.getPlayer().sendMessage(ChatColor.DARK_RED + "You cannot ping that role!");
            e.setCancelled(true);
            return;
        }
        plugin.sendChat(e.getPlayer(), e.getMessage());
    }
}
