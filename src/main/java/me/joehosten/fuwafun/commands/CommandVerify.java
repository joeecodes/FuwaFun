package me.joehosten.fuwafun.commands;

import dev.negativekb.api.plugin.command.Command;
import dev.negativekb.api.plugin.command.annotation.CommandInfo;
import me.joehosten.fuwafun.FuwaFun;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

@CommandInfo(name = "verify", description = "Verify a new player", permission = "fuwafun.verify", args = {"player"})
public class CommandVerify extends Command {

    private final FuwaFun plugin;

    public CommandVerify() {
        this.plugin = FuwaFun.getInstance();
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (!getPlayer(args[0]).isPresent()) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCould not find that player!"));
            return;
        }
        OfflinePlayer t = Bukkit.getPlayer(args[0]);
        Player p = (Player) sender;
        assert t != null;
        verifyPlayer(t, p);
    }

    private void verifyPlayer(OfflinePlayer target, Player sender) {
        FileConfiguration config = plugin.getConfig();
        boolean isVerified = config.getStringList("verified").contains(target.getUniqueId().toString());
        boolean status;
        List<String> verified = config.getStringList("verified");
        if (isVerified) {
            verified.remove(target.getUniqueId().toString());
            status = false;
        } else {
            verified.add(target.getUniqueId().toString());
            status = true;
        }
        String done = status ? "Verified" : "Unverified";
        String doneTarget = status ? "verified" : "unverified";
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a%done% &e%player%&a.").replace("%done%", done).replace("%player%", Objects.requireNonNull(target.getName())));
        if (target.isOnline()) {
            Player t = (Player) target;
            t.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou were &e%done%&a by &e%sender%.").replace("%done%", doneTarget).replace("%sender%", sender.getName()));
        }
        config.set("verified", verified);
        plugin.saveConfig();
    }
}
