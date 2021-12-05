package me.joehosten.fuwafun;

import dev.negativekb.api.plugin.BasePlugin;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import me.joehosten.fuwafun.commands.CommandPing;
import me.joehosten.fuwafun.listeners.ChatListener;
import me.joehosten.fuwafun.listeners.JoinListener;
import me.joehosten.fuwafun.listeners.discord.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class FuwaFun extends BasePlugin {

    @Getter
    @Setter
    private static FuwaFun instance;
    public final Map<String, String> advancementToDisplayMap = new HashMap<>();
    private JDA jda;
    @Getter
    @Setter
    private TextChannel textChannel;

    @SneakyThrows
    @Override
    public void onEnable() {
        setInstance(this);

        registerListeners(new JoinListener(),
                new MinecraftPlayerAdvancementEvent(this),
                new MinecraftPlayerDeathEvent(this),
                new MinecraftToDiscordChatEvent(this),
                new MinecraftPlayerLogEvent(this),
                new ChatListener()
        );

        registerCommands(new CommandPing());

        saveDefaultConfig();

        // Discord
        String botToken = getConfig().getString("bot-token");
        String textChannelId = getConfig().getString("text-channel-id");
        jda = JDABuilder.createDefault(botToken).build().awaitReady();
        if (textChannelId != null) {
            textChannel = jda.getTextChannelById(textChannelId);
        }

        ConfigurationSection advancementMap = getConfig().getConfigurationSection("advancementMap");
        if (advancementMap != null) {
            for (String key : advancementMap.getKeys(false)) {
                advancementToDisplayMap.put(key, advancementMap.getString("key"));
            }
        }
        jda.addEventListener(new DiscordToMinecraftChatEvent(this));

        sendEmbed("Server online", Color.GREEN);
    }

    @Override
    public void onDisable() {
        sendEmbed("Server offline", Color.RED);
        if (jda != null) jda.shutdownNow();

    }

    public void sendEmbed(Player player, String content, boolean contentAuthorLine, Color color) {
        if (textChannel == null) return;

        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(contentAuthorLine ? content : player.getDisplayName(),
                        null,
                        "https://crafatar.com/avatars/" + player.getUniqueId().toString() + "?overlay=1");
        builder.setColor(color);
        if (!contentAuthorLine) {
            builder.setDescription(content);
        }

        textChannel.sendMessageEmbeds(builder.build()).queue();
    }

    private void sendEmbed(String content, Color color) {
        if (textChannel == null) return;

        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(content,
                        null,
                        "https://crafatar.com/avatars/295e76d2-d6c2-487e-932c-8a10f8a46246?overlay=1");
        builder.setColor(color);
        textChannel.sendMessageEmbeds(builder.build()).queue();
    }

    public void sendChat(Player player, String content) {
        if (textChannel == null) return;
        textChannel.sendMessage("**" + player.getDisplayName() + "**: " + content).queue();
    }
}
