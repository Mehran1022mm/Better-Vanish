package net.moamele.Vanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Main extends JavaPlugin implements CommandExecutor, Listener {

    private final Set<Player> VanishedPlayers = new HashSet<>();

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Config.loadConfig();
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("vanish")).setExecutor(this);
    }
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Vanish")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            if (!sender.hasPermission("vanish.use")) {
                sender.sendMessage(Config.PREFIX + Config.NOP);
                return true;
            }
            Player player = (Player) sender;
            Boolean IsVanished = VanishedPlayers.contains(player);
            if (IsVanished) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(this, player);
                }
                VanishedPlayers.remove(player);
                player.sendMessage(Config.PREFIX + Config.DISABLE);
            } else {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(this, player);
                }
                VanishedPlayers.add(player);
                player.sendMessage(Config.PREFIX + Config.ENABLE);
            }
            return true;
        }
        return false;
    }
    @EventHandler
    public void OnPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Config.AUTO) {
            return;
        }
        if (player.hasPermission("vanish.use")) {
            VanishedPlayers.add(player);
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.hidePlayer(this, player);
            }
            player.sendMessage(Config.PREFIX + Config.ENABLE);
        }
    }
    @EventHandler
    public void OnPlayerQuit (PlayerQuitEvent event) {
        Player player = event.getPlayer();
        VanishedPlayers.remove(player);
    }
    @EventHandler
    public void OnPlayerChat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!VanishedPlayers.contains(player)) {
            return;
        }
        event.setCancelled(true);
        player.sendMessage(Config.PREFIX + Config.CHAT);
    }
    public static Main getInstance () {
        return instance;
    }
    public static String Color (String Str) {
        return ChatColor.translateAlternateColorCodes('&', Str);
    }
}
