package me.eren.chiroptera.core.packets;

import me.eren.chiroptera.core.Packet;

/**
 * Sent by the client when they are disconnecting so the server can properly handle it.
 * If the client disconnects without sending this, they will be eventually timed out.
 */
public class DisconnectPacket extends Packet {
    public DisconnectPacket() {
        super((byte) -5, null);
    }
}
