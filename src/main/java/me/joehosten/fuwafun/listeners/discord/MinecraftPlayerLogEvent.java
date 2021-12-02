package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class MinecraftPlayerLogEvent implements Listener {

    private final FuwaFun plugin;

    public MinecraftPlayerLogEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    // Joining
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        plugin.sendEmbed(e.getPlayer(), e.getPlayer().getDisplayName() + " joined the server!", true, Color.GREEN);
    }

    // Quitting
    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent e) {
        plugin.sendEmbed(e.getPlayer(), e.getPlayer().getDisplayName() + " left the server!", true, Color.ORANGE);
    }
}
