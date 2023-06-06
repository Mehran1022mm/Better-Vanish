package net.moamele.Vanish;

import net.moamele.Vanish.Commands.VanishCommand;
import net.moamele.Vanish.Listeners.AsyncPlayerChatListener;
import net.moamele.Vanish.Listeners.PlayerJoinListener;
import net.moamele.Vanish.Listeners.PlayerQuitListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Main extends JavaPlugin {

    private static final Set<Player> VanishedPlayers = new HashSet<>();

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Config.loadConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCommand());
    }
    public static Main getInstance () {
        return instance;
    }
    public static Set<Player> getVanishedPlayers () {
        return VanishedPlayers;
    }
    public static String Color (String Str) {
        return ChatColor.translateAlternateColorCodes('&', Str);
    }
}
