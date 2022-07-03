package de.celinadev.celib;

public class LogUtil {

    public void log(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().info("§7[§b" + prefix + "§7] §a" + message);
    }

    public void warn(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().warning("§7[§b" + prefix + "§7] §a" + message);
    }

    public void error(String prefix, String message) {
        CeLib.getInstance().getPlugin().getLogger().severe("§7[§b" + prefix + "§7] §a" + message);
    }
}