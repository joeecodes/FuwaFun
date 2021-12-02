package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public class MinecraftToDiscordChatEvent implements Listener {

    private final FuwaFun plugin;

    public MinecraftToDiscordChatEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        plugin.sendChat(e.getPlayer(), e.getMessage());
    }
}
