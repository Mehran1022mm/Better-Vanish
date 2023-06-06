package net.moamele.Vanish;

import org.bukkit.configuration.file.FileConfiguration;

public final class Config {

    public static String PREFIX;
    public static Boolean AUTO;
    public static String NOP;
    public static String ENABLE;
    public static String DISABLE;
    public static String CHAT;
    public static void loadConfig() {
        Main instance = Main.getInstance();
        instance.reloadConfig();
        FileConfiguration Config = instance.getConfig();

        PREFIX = Main.Color(Config.getString("Prefix") + " ");
        AUTO = Config.getBoolean("Auto-Vanish");
        NOP = Config.getString("Message.No-Permission");
        ENABLE = Main.Color(Config.getString("Message.Vanish-Enable"));
        DISABLE = Main.Color(Config.getString("Message.Vanish-Disable"));
        CHAT = Main.Color(Config.getString("Message.Cant-Chat"));
    }
}
