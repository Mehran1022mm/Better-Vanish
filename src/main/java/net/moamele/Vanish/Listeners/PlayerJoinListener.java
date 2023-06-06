package net.moamele.Vanish.Listeners;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.moamele.Vanish.Main.getVanishedPlayers;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void OnPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Config.AUTO) {
            return;
        }
        if (player.hasPermission("vanish.use")) {
            getVanishedPlayers().add(player);
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.hidePlayer(Main.getInstance(), player);
            }
            player.sendMessage(Config.PREFIX + Config.ENABLE);
        }
    }
}
