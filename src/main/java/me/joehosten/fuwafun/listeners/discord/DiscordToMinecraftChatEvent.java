package me.joehosten.fuwafun.listeners.discord;

import me.joehosten.fuwafun.FuwaFun;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public final class DiscordToMinecraftChatEvent extends ListenerAdapter {
    private final FuwaFun plugin;

    public DiscordToMinecraftChatEvent(FuwaFun plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent e) {
        if (!e.getChannel().equals(plugin.getTextChannel())) return;

        Member member = e.getMember();
        if (member == null || member.getUser().isBot()) return;

        String message = e.getMessage().getContentDisplay();
        String author = e.getMessage().getAuthor().getName();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[DISCORD] &f" + author + ": " + message));
        }
    }
}
