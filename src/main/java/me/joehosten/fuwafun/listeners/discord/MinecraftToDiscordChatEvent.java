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
        if (e.getMessage().contains("@everyone")) {
            e.getPlayer().sendMessage(ChatColor.DARK_RED + "You cannot do that!");
            e.setCancelled(true);
            return;
        }
        plugin.sendChat(e.getPlayer(), e.getMessage());
    }
}
