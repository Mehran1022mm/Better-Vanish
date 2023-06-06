package net.moamele.Vanish.Commands;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import net.moamele.Vanish.Utils.Vanish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Vanish")) {
            if (!(sender instanceof Player)) return true;
            if (!sender.hasPermission("vanish.use")) { sender.sendMessage(Config.PREFIX + Config.NOP); return true; }
            Player player = (Player) sender;
            boolean IsVanished = Main.getVanishedPlayers().contains(player);
            if (IsVanished) {
                Vanish.disableVanish(player);
            } else {
                Vanish.enableVanish(player);
            }
            return true;
        }
        return false;
    }
}
