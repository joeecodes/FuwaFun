package me.joehosten.fuwafun.commands;

import dev.negativekb.api.plugin.command.Command;
import dev.negativekb.api.plugin.command.annotation.CommandInfo;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "ping", aliases = {"latency"})
public class CommandPing extends Command {
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You cannot issue this command as console.");
            }
            assert sender instanceof Player;
            Player p = (Player) sender;
            sender.sendMessage(ChatColor.GREEN + "Your ping is " + ChatColor.YELLOW + p.getPing());
            return;
        }
        if(!getPlayer(args[0]).isPresent()) {
            sender.sendMessage(ChatColor.RED + "That player does not exist or is not online.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        assert target != null;
        sender.sendMessage(ChatColor.GREEN + target.getName() + "'s ping is " + ChatColor.YELLOW + target.getPing());
    }
}
