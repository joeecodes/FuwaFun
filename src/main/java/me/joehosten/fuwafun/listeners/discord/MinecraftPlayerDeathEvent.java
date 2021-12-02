package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.awt.*;

public class MinecraftPlayerDeathEvent implements Listener {
    private final FuwaFun plugin;

    public MinecraftPlayerDeathEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getPlayer();
        String deathMessage = e.getDeathMessage() == null ? p.getDisplayName() + " died." : e.getDeathMessage();
        plugin.sendEmbed(p, deathMessage, true, Color.RED);
    }
}
