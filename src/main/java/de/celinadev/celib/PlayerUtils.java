package de.celinadev.celib;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Utilities for messing with a player itself.
 *
 * @author Cxlina
 */
public class PlayerUtils {

    private static final JavaPlugin plugin = CeLib.getInstance().getPlugin();

    /**
     * NOTE: This method will remove all other changes in the player's Display-Name.
     */
    public static void setPrefix(Player player, String prefix) {
        player.setDisplayName(prefix + player.getName());
        player.setPlayerListName(prefix + player.getName());
    }

    /**
     * NOTE: This method only works if the Player's current Display-Name still contains it's actual Username
     */
    public static String getPrefix(Player player) {
        int i = player.getName().length();
        return player.getDisplayName().split(player.getName())[0];
    }

    /**
     * NOTE: This method will remove all other changes in the player's Display-Name.
     */
    public static void setSuffix(Player player, String suffix) {
        player.setDisplayName(player.getName() + suffix);
        player.setPlayerListName(player.getName() + suffix);
    }

    /**
     * NOTE: This method only works if the Player's current Display-Name still contains it's actual Username
     */
    public static String getSuffix(Player player) {
        int i = player.getName().length();
        return player.getDisplayName().split(player.getName())[1];
    }

    /**
     * This can be used if you want to change both pre- and suffix.
     */
    public static void setPrefixAndSuffix(Player player, String prefix, String suffix) {
        player.setDisplayName(prefix + player.getName() + suffix);
        player.setPlayerListName(prefix + player.getName() + suffix);
    }
}
