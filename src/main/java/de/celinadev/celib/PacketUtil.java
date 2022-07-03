package de.celinadev.celib;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

/**
 * Utilities for sending Packets to a player's Client without use of NMS.
 *
 * @author Cxlina
 */
public class PacketUtil {

    //TODO: add plugin constant

    /**
     * This only accepts data that is one of the types below. If any of the given data is not applicable, it will not be written into the Buffer, which means it won't be received by the client.
     */
    public static void sendPacketToClient(Player player, String channel, Object... data) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        for (Object obj : data) {
            if (obj instanceof Boolean v) out.writeBoolean(v);
            else if (obj instanceof Byte v) out.writeByte(v);
            else if (obj instanceof Short v) out.writeShort(v);
            else if (obj instanceof Character v) out.writeChar(v);
            else if (obj instanceof Integer v) out.writeInt(v);
            else if (obj instanceof Long v) out.writeLong(v);
            else if (obj instanceof Float v) out.writeFloat(v);
            else if (obj instanceof Double v) out.writeDouble(v);
            else if (obj instanceof String v) out.writeUTF(v);
        }
        if (!CeLib.getInstance().getPlugin().getServer().getMessenger().isOutgoingChannelRegistered(CeLib.getInstance().getPlugin(), CeLib.getInstance().getPlugin().getName().toLowerCase() + ":" + channel))
            CeLib.getInstance().getPlugin().getServer().getMessenger().registerOutgoingPluginChannel(CeLib.getInstance().getPlugin(), CeLib.getInstance().getPlugin().getName().toLowerCase() + ":" + channel);
        player.sendPluginMessage(CeLib.getInstance().getPlugin(), CeLib.getInstance().getPlugin().getName().toLowerCase() + ":" + channel, out.toByteArray());
    }
}
