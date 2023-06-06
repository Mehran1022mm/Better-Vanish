package net.moamele.Vanish.Listeners;

import net.moamele.Vanish.Config;
import net.moamele.Vanish.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {
    @EventHandler
    public void OnPlayerChat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!Main.getVanishedPlayers().contains(player)) return;
        event.setCancelled(true);
        player.sendMessage(Config.PREFIX + Config.CHAT);
    }
}
