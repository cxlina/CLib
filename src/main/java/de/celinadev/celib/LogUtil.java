package de.celinadev.celib;

public class LogUtil {

    public static void log(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().info("§7[§b" + prefix + "§7] §a" + message);
    }

    public static void warn(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().warning("§7[§b" + prefix + "§7] §a" + message);
    }

    public static void error(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().severe("§7[§b" + prefix + "§7] §a" + message);
    }
}