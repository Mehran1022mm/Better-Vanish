package net.moamele.Vanish.Listeners;

import net.moamele.Vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerQuitListener implements Listener {
    @EventHandler
    public void OnPlayerQuit (PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Main.getVanishedPlayers().remove(player);
    }
}
