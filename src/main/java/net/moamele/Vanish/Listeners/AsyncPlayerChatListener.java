package net.moamele.Vanish.Listeners;

import net.moamele.Vanish.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static net.moamele.Vanish.Main.getVanishedPlayers;

public class AsyncPlayerChatListener implements Listener {
    @EventHandler
    public void OnPlayerChat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!getVanishedPlayers().contains(player)) {
            return;
        }
        event.setCancelled(true);
        player.sendMessage(Config.PREFIX + Config.CHAT);
    }
}
