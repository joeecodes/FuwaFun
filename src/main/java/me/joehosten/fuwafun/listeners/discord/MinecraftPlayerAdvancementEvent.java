package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import java.awt.*;

public class MinecraftPlayerAdvancementEvent implements Listener {
    private final FuwaFun plugin;

    public MinecraftPlayerAdvancementEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent e) {
        String advancementKey = e.getAdvancement().getKey().getKey();
        String display = plugin.advancementToDisplayMap.get(advancementKey);
        if (display == null) return;
        plugin.sendEmbed(e.getPlayer(), e.getPlayer().getDisplayName() + " has achieved the advancement **[" + display + "]**", true, Color.CYAN);
    }
}
