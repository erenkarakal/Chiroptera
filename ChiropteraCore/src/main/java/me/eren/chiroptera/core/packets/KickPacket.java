package me.eren.chiroptera.core.packets;

import me.eren.chiroptera.core.Packet;

import java.io.Serializable;

/**
 * Sent by the server when it kicks a client for whatever reason. Client uses this to log the kick reason and properly disconnect.
 */
public class KickPacket extends Packet {

    private final String reason;

    public KickPacket(String reason) {
        super((byte) -4, new Serializable[]{ reason });
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }
    
}
