package me.joehosten.fuwafun.listeners;

import me.joehosten.fuwafun.FuwaFun;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JoinListener implements Listener {

    private final List<String> toSendOnJoin;
    private final FuwaFun plugin;

    public JoinListener() {
        plugin = FuwaFun.getInstance();
        this.toSendOnJoin = Arrays.asList(" ", "&3Welcome to FuwaSMP!&r", " ", "&r%message%&r", " ");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Date date = java.util.Calendar.getInstance().getTime();
        Player p = e.getPlayer();
        System.out.println(date);
        switch (date.getDay()) {
            case 1: // Monday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&d&lWOOOOOOO ITS MIO MONDAY"))));
                return;
            case 2: // Tuesday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&d&lHOLY CRAP ITS TAINAKA TUESDAY"))));
                return;
            case 3: // Wednesday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&3&lHELL YEAH ITS WAKABA WEDNESDAY"))));
                return;
            case 4: // Thursday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&6&lFELIZ JUEVES"))));
                return;
            case 5: // Friday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&d&lOMGOMGOMG ITS FUCKING &5&L&KK &D&LFUWA FUWA FRIDAY &5&L&KK"))));
                return;
            case 6: // Saturday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&d&lHELL YEAH ITS SAWAKO SATURDAY"))));
                return;
            case 0: // Sunday
                toSendOnJoin.forEach(s -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', s.replace("%message%", "&c&lNO WAYYYYYYY.. ITS SUMI SUNDAY"))));
        }
    }

    @EventHandler
    public void onFreezeMovement(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location from = e.getFrom();
        boolean isVerified = plugin.getConfig().getStringList("verified").contains(p.getUniqueId().toString());
        if (!isVerified) {
            p.teleport(from);
        }
    }
}
