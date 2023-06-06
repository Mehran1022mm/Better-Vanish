package net.moamele.Vanish.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.moamele.Vanish.Main.getVanishedPlayers;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void OnPlayerQuit (PlayerQuitEvent event) {
        Player player = event.getPlayer();
        getVanishedPlayers().remove(player);
    }
}
