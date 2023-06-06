package net.moamele.Vanish.Utils;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static net.moamele.Vanish.Main.getVanishedPlayers;

public class Vanish {

    public static void enableVanish (Player player) {
        Main.getVanishedPlayers().add(player);
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p == player) {
                return;
            }
            p.hidePlayer(Main.getInstance(), player);
        }
        player.sendMessage(Config.PREFIX + Config.ENABLE);
    }

    public static void disableVanish (Player player) {
        getVanishedPlayers().remove(player);
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.showPlayer(Main.getInstance(), player);
        }
        player.sendMessage(Config.PREFIX + Config.DISABLE);
    }
}
