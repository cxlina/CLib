package de.celinadev.celib;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeeUtil {

    /**
     * Moves the given player to the given server. Even if the plugin message was sent successfully, that doesn't necessarily mean the player was moved as well. Example: Destination-Server is offline.
     *
     * @param player The Player to move
     * @param from The Server the player is coming from
     * @param to the Server to move the player to
     * @return true if message was sent successfully
     */
    public static boolean moveToServer(Player player, String from, String to) {
        try {
            if (!Bukkit.getMessenger().isOutgoingChannelRegistered(CeLib.getInstance().getPlugin(), "BungeeCord"))
                Bukkit.getMessenger().registerOutgoingPluginChannel(CeLib.getInstance().getPlugin(), "BungeeCord");
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF(to);
            player.sendPluginMessage(CeLib.getInstance().getPlugin(), "BungeeCord", out.toByteArray());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
