package net.moamele.Vanish.Listeners;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import net.moamele.Vanish.Utils.Vanish;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void OnPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Config.AUTO) return;
        if (player.hasPermission("vanish.use")) { Vanish.enableVanish(player); }
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("vanish.use") && Main.getVanishedPlayers().contains(p)) {
                if (player.hasPermission("vanish.use")) return;
                player.hidePlayer(Main.getInstance(), p);
            }
        }
    }
}
