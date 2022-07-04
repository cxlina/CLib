package de.celinadev.celib;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

/**
 * Utilities for Messing with the Player's PersistentDataContainer (NBT-Data)
 *
 * @author Cxlina
 */
public class PDCUtil {

    //TODO: add plugin constant

    public static void setString(Player player, String key, String data) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(CeLib.getInstance().getPlugin(), key), PersistentDataType.STRING, data);
    }

    public static String getString(Player player, String key) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.getOrDefault(new NamespacedKey(CeLib.getInstance().getPlugin(), key), PersistentDataType.STRING, "");
    }

    public static void setInt(Player player, String key, Integer data) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(CeLib.getInstance().getPlugin(), key), PersistentDataType.INTEGER, data);
    }

    public static Integer getInt(Player player, String key) {
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.getOrDefault(new NamespacedKey(CeLib.getInstance().getPlugin(), key), PersistentDataType.INTEGER, 0);
    }

    public static void setBoolean(Player player, String key, Boolean data) {
        setInt(player, key, data ? 1 : 0);
    }

    public static Boolean getBoolean(Player player, String key) {
        return getInt(player, key) == 1;
    }
}