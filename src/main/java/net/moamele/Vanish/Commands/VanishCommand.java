package net.moamele.Vanish.Commands;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.moamele.Vanish.Main.getVanishedPlayers;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Vanish")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            if (!sender.hasPermission("vanish.use")) {
                sender.sendMessage(Config.PREFIX + Config.NOP);
                return true;
            }
            Player player = (Player) sender;
            boolean IsVanished = getVanishedPlayers().contains(player);
            if (IsVanished) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(Main.getInstance(), player);
                }
                getVanishedPlayers().remove(player);
                player.sendMessage(Config.PREFIX + Config.DISABLE);
            } else {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(Main.getInstance(), player);
                }
                getVanishedPlayers().add(player);
                player.sendMessage(Config.PREFIX + Config.ENABLE);
            }
            return true;
        }
        return false;
    }
}
